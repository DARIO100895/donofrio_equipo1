package org.equipo1.transacciones.infrastructure.adapter.output.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompraDetalleEvent {

    private UUID sku;
    private String numeroLote;
    private LocalDate fechaVencimiento;
    private Integer cantidad;
    private BigDecimal costoUnitario;
    private BigDecimal subtotal;
}
