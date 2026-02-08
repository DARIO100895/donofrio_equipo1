package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;
import org.equipo1.transacciones.domain.model.Compra;
import org.equipo1.transacciones.domain.model.CompraDetalle;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraDetalleEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;

import java.util.stream.Collectors;

public class CompraMapper {

    public static CompraEntity toEntity(Compra compra) {
        if (compra == null) return null;

        CompraEntity entity = new CompraEntity();
        entity.setIdCompra(compra.getIdCompra());
        entity.setFechaCompra(compra.getFechaCompra());
        entity.setProveedor(compra.getProveedor());
        entity.setTotal(compra.getTotal());
        entity.setEstado(compra.getEstado());
        entity.setFechaCreacion(compra.getFechaCreacion());
        entity.setFechaActualizacion(compra.getFechaActualizacion());

        if (compra.getDetalles() != null) {
            entity.setDetalles(
                    compra.getDetalles().stream()
                            .map(d -> {
                                CompraDetalleEntity detalleEntity = new CompraDetalleEntity();
                                detalleEntity.setIdDetalle(d.getIdDetalle());
                                detalleEntity.setCompra(entity);
                                detalleEntity.setNumeroLote(d.getNumeroLote());
                                detalleEntity.setFechaVencimiento(d.getFechaVencimiento());
                                detalleEntity.setCantidad(d.getCantidad());
                                detalleEntity.setCostoUnitario(d.getCostoUnitario());
                                return detalleEntity;
                            })
                            .collect(Collectors.toList())
            );
        }

        return entity;
    }

    // Entity -> Domain
    public static Compra toDomain(CompraEntity entity) {
        if (entity == null) return null;

        Compra compra = new Compra();
        compra.setIdCompra(entity.getIdCompra());
        compra.setFechaCompra(entity.getFechaCompra());
        compra.setProveedor(entity.getProveedor());
        compra.setTotal(entity.getTotal());
        compra.setEstado(entity.getEstado());
        compra.setFechaCreacion(entity.getFechaCreacion());
        compra.setFechaActualizacion(entity.getFechaActualizacion());

        if (entity.getDetalles() != null) {
            compra.setDetalles(
                    entity.getDetalles().stream()
                            .map(d -> {
                                CompraDetalle detalle = new CompraDetalle();
                                detalle.setIdDetalle(d.getIdDetalle());
                                detalle.setSku(d.getProducto() != null ? d.getProducto().getSku() : null);
                                detalle.setNumeroLote(d.getNumeroLote());
                                detalle.setFechaVencimiento(d.getFechaVencimiento());
                                detalle.setCantidad(d.getCantidad());
                                detalle.setCostoUnitario(d.getCostoUnitario());
                                detalle.setSubtotal(d.getSubtotal());
                                return detalle;
                            })
                            .collect(Collectors.toList())
            );
        }

        return compra;
    }
}

