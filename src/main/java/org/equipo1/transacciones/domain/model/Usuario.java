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
public class Usuario {

    private UUID idUsuario;
    private String username;
    private String passwordHash;
    private String nombre;
    private Integer idRol;
    private Rol rol;
    private Boolean activo;
    private LocalDateTime fechaCreacion;

/** Obtener nombre completo del usuario*/

public String getNombreUsuario() {
    if(nombre != null) {
        return nombre;
    }
    return username;
}
    /** Verifica si el usuario está activo */
public boolean Activo() {
    return Boolean.TRUE.equals(this.activo);
}


}
