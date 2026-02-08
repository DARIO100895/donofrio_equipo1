package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.PrecioCompraProducto;
import org.equipo1.transacciones.domain.model.PrecioVentaProducto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.PrecioCompraProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.PrecioVentaProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;

public class PrecioVentaProductoMapper {

    public static PrecioVentaProducto toDomain(PrecioVentaProductoEntity entity) {
        if (entity == null) return null;

        PrecioVentaProducto model = new PrecioVentaProducto();
        model.setIdPrecio(entity.getIdPrecio());
        model.setPrecioUnitario(entity.getPrecioUnitario());
        model.setFechaVigencia(entity.getFechaVigencia());
        model.setActivo(entity.getActivo());
        return model;
    }

    // Model -> Entity
    public static PrecioVentaProductoEntity toEntity(PrecioVentaProducto model, ProductoEntity producto) {
        if (model == null) return null;

        PrecioVentaProductoEntity entity = new PrecioVentaProductoEntity();
        entity.setIdPrecio(model.getIdPrecio());
        entity.setPrecioUnitario(model.getPrecioUnitario());
        entity.setFechaVigencia(model.getFechaVigencia());
        entity.setActivo(model.getActivo());
        entity.setProducto(producto);
        return entity;
    }
}
