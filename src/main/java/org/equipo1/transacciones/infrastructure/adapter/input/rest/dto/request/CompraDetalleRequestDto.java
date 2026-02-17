package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraDetalleRequestDto {

    private UUID sku;
    private String numeroLote;
    private LocalDate fechaVencimiento;
    private Integer cantidad;
    private BigDecimal costoUnitario;
}
