package org.equipo1.transacciones.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

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
