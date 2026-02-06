package org.equipo1.transacciones.application.ports.out;

import org.equipo1.transacciones.domain.model.Producto;

import java.util.Optional;
import java.util.UUID;

public interface ProductoRepository {

    void guardar(Producto producto);

    Optional<Producto> buscarPorSku(UUID sku);
}
