package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.domain.model.Compra;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.CompraRequest;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.CompraResponse;

public interface CompraUseCase {

    public CompraResponse registrarCompra(CompraRequest request);

    public CompraResponse publicarCompra(Integer idCompra);
}
