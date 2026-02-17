package org.equipo1.transacciones.infrastructure.adapter.output.client;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.UUID;

@FeignClient(name = "producto-service", url = "${feign.producto.url}")
public interface ProductoClient {

    @GetMapping("/{sku}/stock")
    StockResponseDto getStockBySku(@PathVariable("sku") UUID sku);

    @GetMapping("/{sku}/lotes")
    ProductoLotesResponseDto getLotesBySku(@PathVariable("sku") UUID sku);

}
