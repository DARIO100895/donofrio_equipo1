package org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa;

import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolJpaRepository extends JpaRepository<RolEntity, Integer> {

    Optional<RolEntity> findByNombre(String nombre);

}
