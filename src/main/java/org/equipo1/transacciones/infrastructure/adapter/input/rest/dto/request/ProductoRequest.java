package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductoRequest {

    private String nombre;
    private String presentacion;
    private Integer idCategoria;
    private Integer cantidadPorCaja;
    private String tipoEmpaque;
    private BigDecimal precio;
}