package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.Compra;
import org.equipo1.transacciones.domain.model.CompraDetalle;
import org.equipo1.transacciones.infrastructure.adapter.output.messaging.dto.CompraDetalleEvent;
import org.equipo1.transacciones.infrastructure.adapter.output.messaging.dto.CompraIngresadaEvent;

import java.util.stream.Collectors;

public class CompraIngresadaEventMapper {

    public static CompraIngresadaEvent fromDomain(Compra compra) {
        return CompraIngresadaEvent.builder()
                .idCompra(compra.getIdCompra())
                .fechaCompra(compra.getFechaCompra())
                .proveedor(compra.getProveedor())
                .total(compra.getTotal())
                .estado(compra.getEstado())
                .detalles(
                        compra.getDetalles().stream()
                                .map(CompraIngresadaEventMapper::mapDetalle)
                                .collect(Collectors.toList())
                )
                .build();
    }

    private static CompraDetalleEvent mapDetalle(CompraDetalle detalle) {
        return CompraDetalleEvent.builder()
                .sku(detalle.getSku())
                .numeroLote(detalle.getNumeroLote())
                .fechaVencimiento(detalle.getFechaVencimiento())
                .cantidad(detalle.getCantidad())
                .costoUnitario(detalle.getCostoUnitario())
                .subtotal(detalle.getSubtotal())
                .build();
    }


}
