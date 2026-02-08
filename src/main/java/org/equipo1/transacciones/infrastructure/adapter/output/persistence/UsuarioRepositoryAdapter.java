package org.equipo1.transacciones.infrastructure.adapter.output.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.equipo1.transacciones.application.ports.out.UsuarioRepository;
import org.equipo1.transacciones.domain.model.Usuario;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.UsuarioEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.UsuarioJpaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper.UsuarioMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        log.debug("Buscando usuario por username: {}", username);

        Optional<UsuarioEntity> entityOptional = usuarioJpaRepository.findByUsername(username);

        return entityOptional.map(usuarioMapper::toDomain);
    }
}