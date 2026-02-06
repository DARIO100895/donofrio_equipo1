package org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa;

import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, UUID> {

}
