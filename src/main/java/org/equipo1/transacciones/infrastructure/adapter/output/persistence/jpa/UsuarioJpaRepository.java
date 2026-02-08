package org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa;

import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, UUID> {

    Optional<UsuarioEntity> findByUsername(String username);
}
