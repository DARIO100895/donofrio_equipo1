package org.equipo1.transacciones;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.LoteDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.output.client.ProductoApiClientAdapter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext
@TestPropertySource(properties = {

        "feign.producto.url=http://localhost:9090"
})
class ProductoFeignClientTest {

    @Autowired
    private ProductoApiClientAdapter productoApiClientAdapter;

    private static WireMockServer wireMockServer;

    private final UUID sku = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");

    @BeforeAll
    static void iniciarWireMock() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(9090));
        wireMockServer.start();
        configureFor("localhost", 9090);
    }

    @AfterAll
    static void detenerWireMock() {
        wireMockServer.stop();
    }

    // Test 1: StockResponseDto

    @Test
    void debeDeserializarStockResponseDto() {
        wireMockServer.stubFor(get(urlEqualTo("/" + sku + "/stock"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                    {
                        "sku": "550e8400-e29b-41d4-a716-446655440000",
                        "existencias": 42,
                        "actualizacion": "2025-06-01T10:00:00"
                    }
                """)
                )
        );

        StockResponseDto result = productoApiClientAdapter.obtenerStock(sku);

        assertThat(result).isNotNull();
        assertThat(result.getSku()).isEqualTo(sku);
        assertThat(result.getExistencias()).isEqualTo(42);
        assertThat(result.getActualizacion()).isNotNull();
    }

    // Test 2: ProductoLotesResponseDto + LoteDto
    @Test
    void debeDeserializarProductoLotesResponseDto() {
        wireMockServer.stubFor(get(urlEqualTo("/" + sku + "/lotes"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                    {
                        "sku": "550e8400-e29b-41d4-a716-446655440000",
                        "producto": "Alaska Fresa 70ml",
                        "lotes": [
                            {
                                "lotes_id": 1,
                                "lote": "LOT-2025-001",
                                "fecha_ing": "2025-01-15T08:00:00",
                                "fecha_ven": "2026-01-15T00:00:00",
                                "unidades": 100,
                                "valor": 5.50
                            },
                            {
                                "lotes_id": 2,
                                "lote": "LOT-2025-002",
                                "fecha_ing": "2025-03-10T08:00:00",
                                "fecha_ven": "2026-03-10T00:00:00",
                                "unidades": 50,
                                "valor": 5.75
                            }
                        ]
                    }
                """)
                )
        );

        ProductoLotesResponseDto result = productoApiClientAdapter.obtenerLotes(sku);

        assertThat(result).isNotNull();
        assertThat(result.getSku()).isEqualTo(sku);
        assertThat(result.getProducto()).isEqualTo("Alaska Fresa 70ml");
        assertThat(result.getLotes()).hasSize(2);

        LoteDto primerLote = result.getLotes().get(0);
        assertThat(primerLote.getLote()).isEqualTo("LOT-2025-001");
        assertThat(primerLote.getUnidades()).isEqualTo(100);
        assertThat(primerLote.getValor()).isEqualByComparingTo(new BigDecimal("5.50"));
    }

    // Test 3: Manejo de 404

    @Test
    void debeLanzarExcepcionSiElServicioResponde404() {
        wireMockServer.stubFor(get(urlEqualTo("/" + sku + "/stock"))
                .willReturn(aResponse()
                        .withStatus(404)
                )
        );

        org.junit.jupiter.api.Assertions.assertThrows(
                feign.FeignException.class,
                () -> productoApiClientAdapter.obtenerStock(sku)
        );
    }
}