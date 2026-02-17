package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.LoteDto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraDetalleEntity;

public class LoteMapper {

    public static LoteDto toDto (CompraDetalleEntity entity) {
        return LoteDto.builder()
                .lotes_id(entity.getIdDetalle())
                .lote(entity.getNumeroLote())
                .fecha_ing(entity.getCompra().getFechaCompra().atStartOfDay())
                .fecha_ven(entity.getFechaVencimiento().atStartOfDay())
                .unidades(entity.getCantidad())
                .valor(entity.getCostoUnitario())
                .build();
    }
}
