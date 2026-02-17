package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoteDto {

    private Integer lotes_id;
    private String lote;
    private LocalDateTime fecha_ing;
    private LocalDateTime fecha_ven;
    private Integer unidades;
    private BigDecimal valor;
}
