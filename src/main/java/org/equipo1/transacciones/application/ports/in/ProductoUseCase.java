package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;

import java.util.UUID;

public interface ProductoUseCase {

    ProductoResponseDto crearProducto(ProductoRequestDto request);

    ProductoResponseDto obtenerProducto(UUID sku);

    StockResponseDto obtenerStockProducto(UUID sku);

    ProductoLotesResponseDto obtenerLotesProducto(UUID sku);

    void desactivarProducto(UUID sku);
}
