package org.equipo1.transacciones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {

    private Integer idVendedor;
    private String nombre;
    private Integer idTerritorio;
    private Boolean activo;
}
