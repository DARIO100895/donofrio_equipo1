package org.equipo1.transacciones.application.ports.out;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;

import java.util.UUID;

public interface ProductoApiClient {

    StockResponseDto obtenerStock(UUID sku);
    ProductoLotesResponseDto obtenerLotes(UUID sku);
}
