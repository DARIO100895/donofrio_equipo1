package org.equipo1.transacciones.domain.model;

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
public class CompraDetalle {

    private Integer idDetalle;
    private UUID sku;
    private String numeroLote;
    private LocalDate fechaVencimiento;
    private Integer cantidad;
    private BigDecimal costoUnitario;
    private BigDecimal subtotal;

    public BigDecimal calcularSubtotal() {
        if (cantidad != null && costoUnitario != null) {
            return costoUnitario.multiply(BigDecimal.valueOf(cantidad));
        } else {
            return BigDecimal.ZERO;
        }
    }

    public void actualizarSubtotal() {
        this.subtotal = calcularSubtotal();
    }
}

