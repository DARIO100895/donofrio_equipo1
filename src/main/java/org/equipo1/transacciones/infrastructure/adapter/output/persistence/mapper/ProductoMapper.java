package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CategoriaEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;

import java.util.stream.Collectors;

public class ProductoMapper {

    public static ProductoEntity toEntity(Producto producto, CategoriaEntity categoriaEntity) {

        if (producto == null) return null;

        return ProductoEntity.builder()
                .sku(producto.getSku())
                .categoria(categoriaEntity)
                .nombre(producto.getNombre())
                .presentacion(producto.getPresentacion())
                .cantidadPorCaja(producto.getCantidadPorCaja())
                .tipoEmpaque(producto.getTipoEmpaque())
                .precioUnitario(producto.getPrecio())
                .activo(producto.getActivo())
                .fechaCreacion(producto.getFechaCreacion())
                .fechaActualizacion(producto.getFechaActualizacion())
                .build();
    }


    public static Producto toDomain(ProductoEntity e) {
        if (e == null) return null;

        return new Producto(
                e.getSku(),
                e.getCategoria() != null ? e.getCategoria().getIdCategoria() : null,
                e.getNombre(),
                e.getPresentacion(),
                e.getCantidadPorCaja(),
                e.getTipoEmpaque(),
                e.getPrecioUnitario(),
                e.getActivo(),
                e.getFechaCreacion(),
                e.getFechaActualizacion()
        );
    }
}

