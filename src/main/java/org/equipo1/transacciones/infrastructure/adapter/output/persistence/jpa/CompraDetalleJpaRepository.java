package org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa;

import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CompraDetalleJpaRepository  extends JpaRepository<CompraDetalleEntity, Integer> {

    //Buscar lotes de un producto por su "sku"

    List<CompraDetalleEntity> findByProductoSku(UUID productoSku);
}
