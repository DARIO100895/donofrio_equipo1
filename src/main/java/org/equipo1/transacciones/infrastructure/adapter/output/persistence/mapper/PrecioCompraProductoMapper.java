package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.PrecioCompraProducto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.PrecioCompraProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;

import java.time.LocalDateTime;

public class PrecioCompraProductoMapper {


    public static PrecioCompraProducto toDomain(PrecioCompraProductoEntity entity) {
        if (entity == null) return null;

        PrecioCompraProducto model = new PrecioCompraProducto();
        model.setIdPrecio(entity.getIdPrecio());
        model.setPrecioUnitario(entity.getPrecioUnitario());
        model.setFechaVigencia(entity.getFechaVigencia());
        model.setActivo(entity.getActivo());
        return model;
    }

    // Model -> Entity
    public static PrecioCompraProductoEntity toEntity(PrecioCompraProducto model, ProductoEntity producto) {
        if (model == null) return null;

        PrecioCompraProductoEntity entity = new PrecioCompraProductoEntity();
        entity.setIdPrecio(model.getIdPrecio());
        entity.setPrecioUnitario(model.getPrecioUnitario());
        entity.setFechaVigencia(model.getFechaVigencia());
        entity.setActivo(model.getActivo());
        entity.setProducto(producto);
        return entity;
    }
}
