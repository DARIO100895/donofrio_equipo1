package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ProductoResponseDto {

    private UUID sku;
    private String nombre;
    private String presentacion;
    private Integer idCategoria;
    private Integer cantidadPorCaja;
    private BigDecimal precio;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
