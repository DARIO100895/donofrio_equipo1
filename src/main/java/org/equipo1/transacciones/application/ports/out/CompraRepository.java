package org.equipo1.transacciones.application.ports.out;

import org.equipo1.transacciones.domain.model.Compra;

import java.util.Optional;

public interface CompraRepository {

    Compra guardarCompra(Compra compra);

    Compra obtenerPorId(Integer idCompra);
}
