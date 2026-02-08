package org.equipo1.transacciones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

    private Integer idCompra;
    private LocalDate fechaCompra;
    private String proveedor;
    private BigDecimal total;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private List<CompraDetalle> detalles;

    public BigDecimal calcularTotal() {
        if (detalles == null) {
            return BigDecimal.ZERO;
        }
        return detalles.stream()
                .map(d -> d.calcularSubtotal() != null ? d.calcularSubtotal() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void actualizarTotal() {
        this.total = calcularTotal();
    }



}
