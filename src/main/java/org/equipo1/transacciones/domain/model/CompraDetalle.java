package org.equipo1.transacciones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double costoUnitario;
    private Double subtotal;

    public double calcularSubtotal() {
        return (cantidad != null && costoUnitario != null) ? cantidad * costoUnitario : 0.0;
    }

    public void actualizarSubtotal() {
        this.subtotal = calcularSubtotal();
    }
}

