package org.equipo1.transacciones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrecioVentaProducto {

    private Integer idPrecio;
    private BigDecimal precioUnitario;
    private LocalDate fechaVigencia;
    private LocalDateTime fechaActualizacion;
    private Boolean activo;
}
