package org.equipo1.transacciones.application.ports.out;

import org.equipo1.transacciones.domain.model.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findById (UUID id);

}
