package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.Rol;
import org.equipo1.transacciones.domain.model.Usuario;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.RolEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioEntity e) {
        if( e == null ) {
            return null;
        }

        return Usuario.builder()
                .idUsuario(e.getIdUsuario())
                .username(e.getUsername())
                .passwordHash(e.getPasswordHash())
                .rol(toRolDomain(e.getRol()))
                .activo(e.getActivo())
                .fechaCreacion(e.getFechaCreacion())
                .build();
    }

    public UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) {
            return null;
        }

        return UsuarioEntity.builder()
                .idUsuario(domain.getIdUsuario())
                .username(domain.getUsername())
                .passwordHash(domain.getPasswordHash())
                .rol(toRolEntity(domain.getRol()))
                .activo(domain.getActivo())
                .fechaCreacion(domain.getFechaCreacion())
                .build();
    }

    private Rol toRolDomain(RolEntity entity) {
        if (entity == null) {
            return null;
        }

        return Rol.builder()
                .idRol(entity.getIdRol())
                .nombreRol(entity.getNombre())
                .build();
    }

    private RolEntity toRolEntity(Rol domain) {
        if (domain == null) {
            return null;
        }

        return RolEntity.builder()
                .idRol(domain.getIdRol())
                .nombre(domain.getNombreRol())
                .build();
    }
}
