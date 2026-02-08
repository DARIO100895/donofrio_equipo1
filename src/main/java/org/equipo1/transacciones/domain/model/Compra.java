package org.equipo1.transacciones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Double total;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private List<CompraDetalle> detalles;

    public double calcularTotal() {
        return detalles == null ? 0.0
                : detalles.stream()
                .mapToDouble(CompraDetalle::calcularSubtotal)
                .sum();
    }


    public void actualizarTotal() {
        this.total = calcularTotal();
    }



}
