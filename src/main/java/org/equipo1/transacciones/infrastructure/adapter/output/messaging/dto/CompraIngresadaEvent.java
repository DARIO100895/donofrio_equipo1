package org.equipo1.transacciones.infrastructure.adapter.output.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompraIngresadaEvent {

    private Integer idCompra;
    private LocalDate fechaCompra;
    private String proveedor;
    private BigDecimal total;
    private String estado;
    private List<CompraDetalleEvent> detalles;
}
