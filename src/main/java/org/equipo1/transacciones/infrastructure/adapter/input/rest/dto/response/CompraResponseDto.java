package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraResponseDto {

    private Integer idCompra;
    private LocalDate fechaCompra;
    private String proveedor;
    private BigDecimal total;
    private String estado;
    private List<CompraDetalleResponseDto> detalles;
}
