package org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa;

import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompraJpaRepository extends JpaRepository<CompraEntity, Integer> {

    List<CompraEntity> findByFechaCompraBetween(LocalDate inicio, LocalDate fin);

    List<CompraEntity> findByEstado(String estado);
}
