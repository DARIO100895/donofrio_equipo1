package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraRequestDto {

    private LocalDate fechaCompra;
    private String proveedor;
    private List<CompraDetalleRequestDto> detalles;
}
