package org.equipo1.transacciones.infrastructure.adapter.output.persistence;

import org.equipo1.transacciones.application.ports.out.UsuarioRepository;
import org.equipo1.transacciones.domain.model.Rol;
import org.equipo1.transacciones.domain.model.Usuario;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.UsuarioEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.UsuarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioJpaRepository.findByUsername(username)
                .map(this::toDomain);
    }

    @Override
    public Optional<Usuario> findById(UUID id) {
        return usuarioJpaRepository.findById(id)
                .map(this::toDomain);
    }

    private Usuario toDomain(UsuarioEntity entity) {
        Rol rol = new Rol(
                entity.getRol().getIdRol(),
                entity.getRol().getNombre()
        );

        return new Usuario(
                entity.getIdUsuario(),
                entity.getUsername(),
                entity.getPasswordHash(),
                rol,
                entity.getActivo(),
                entity.getFechaCreacion()
        );
    }
}