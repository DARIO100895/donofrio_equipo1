package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.CompraRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.CompraResponseDto;

public interface CompraUseCase {

    public CompraResponseDto registrarCompra(CompraRequestDto request);

    public CompraResponseDto publicarCompra(Integer idCompra);
}
