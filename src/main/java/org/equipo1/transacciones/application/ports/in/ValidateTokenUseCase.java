package org.equipo1.transacciones.application.ports.in;

import org.equipo1.transacciones.domain.model.Usuario;

public interface ValidateTokenUseCase {

    Usuario validateAndGetUser(String token);
}
