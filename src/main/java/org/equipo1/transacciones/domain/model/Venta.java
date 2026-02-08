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
public class Venta {

    private Integer idVenta;
    private String ordenVenta;
    private LocalDate fechaVenta;

    private Integer idVendedor;
    private Integer idCliente;

    private BigDecimal total;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    private List<VentaDetalle> detalles;
}
