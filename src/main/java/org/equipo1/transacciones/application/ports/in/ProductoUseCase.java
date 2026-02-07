package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.domain.model.Producto;

import java.util.UUID;

public interface ProductoUseCase {

    Producto crearProducto(
            String nombre,
            String presentacion,
            String categoria,
            Integer cantidadPorCaja,
            Double precio
    );

    Producto obtenerProducto(UUID sku);

    void desactivarProducto(UUID sku);
}
