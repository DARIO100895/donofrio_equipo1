package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.AuthRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.AuthResponseDto;

public interface AuthenticationUseCase {

    AuthResponseDto authenticate(AuthRequestDto authRequestDto);
}
