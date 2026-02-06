package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ProductoResponse {

    private UUID sku;
    private String nombre;
    private String presentacion;
    private String categoria;
    private Integer cantidadPorCaja;
    private Double precio;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
