package org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa;

import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Integer> {
}
