package org.equipo1.transacciones.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    private Integer idRol;
    private String nombreRol;

    public Integer getIdRol() {
        return idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

}
