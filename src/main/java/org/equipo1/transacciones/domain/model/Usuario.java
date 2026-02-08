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


    public Usuario(UUID idUsuario, String username, String passwordHash,
                   Rol rol, Boolean activo, LocalDateTime fechaCreacion) {

        this.idUsuario = idUsuario;
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    /** Verifica si el usuario está activo */
    public boolean Activo() {
        return Boolean.TRUE.equals(this.activo);
    }

}
