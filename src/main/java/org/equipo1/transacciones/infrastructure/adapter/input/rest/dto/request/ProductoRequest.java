package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductoRequest {

    private UUID sku;
    private String nombre;
    private String presentacion;
    private String categoria;
    private Integer cantidadPorCaja;
    private Double precio;
}