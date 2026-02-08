package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequest;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponse;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductoUseCase {

    ProductoResponse crearProducto(ProductoRequest request);


    ProductoResponse obtenerProducto(UUID sku);


    void desactivarProducto(UUID sku);
}
