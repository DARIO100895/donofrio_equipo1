package org.equipo1.transacciones.infrastructure.adapter.output.client;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.out.ProductoApiClient;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductoApiClientAdapter implements ProductoApiClient {

    private final ProductoClient productoClient;

    @Override
    public StockResponseDto obtenerStock(UUID sku) {
        return productoClient.getStockBySku(sku);
    }

    @Override
    public ProductoLotesResponseDto obtenerLotes(UUID sku) {
        return productoClient.getLotesBySku(sku);
    }
}
