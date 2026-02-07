package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;

public class ProductoMapper {

    public static ProductoEntity toEntity(Producto producto) {
        ProductoEntity e = new ProductoEntity();
        e.setSku(producto.getSku());
        e.setNombre(producto.getNombre());
        e.setPresentacion(producto.getPresentacion());
        e.setCategoria(producto.getCategoria());
        e.setCantidadPorCaja(producto.getCantidadPorCaja());
        e.setPrecio(producto.getPrecio());
        e.setActivo(producto.getActivo());
        e.setFechaCreacion(producto.getFechaCreacion());
        e.setFechaActualizacion(producto.getFechaActualizacion());
        return e;
    }

    public static Producto toDomain(ProductoEntity e) {
        return Producto.builder()
                .sku(e.getSku())
                .nombre(e.getNombre())
                .presentacion(e.getPresentacion())
                .categoria(e.getCategoria())
                .cantidadPorCaja(e.getCantidadPorCaja())
                .precio(e.getPrecio())
                .activo(e.getActivo())
                .fechaCreacion(e.getFechaCreacion())
                .fechaActualizacion(e.getFechaActualizacion())
                .build();
    }
}
