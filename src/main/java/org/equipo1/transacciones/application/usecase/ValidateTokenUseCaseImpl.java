package org.equipo1.transacciones.application.usecase;

import org.equipo1.transacciones.application.ports.in.ValidateTokenUseCase;
import org.equipo1.transacciones.application.ports.out.UsuarioRepository;
import org.equipo1.transacciones.domain.exception.InvalidTokenException;
import org.equipo1.transacciones.domain.model.Usuario;
import org.equipo1.transacciones.infrastructure.security.JwtTokenValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidateTokenUseCaseImpl implements ValidateTokenUseCase {

    private final JwtTokenValidator jwtTokenValidator;
    private final UsuarioRepository usuarioRepository;

    public ValidateTokenUseCaseImpl(JwtTokenValidator jwtTokenValidator,
                                    UsuarioRepository usuarioRepository) {
        this.jwtTokenValidator = jwtTokenValidator;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario validateAndGetUser(String token) {
        if (!jwtTokenValidator.validateToken(token)) {
            throw new InvalidTokenException("Token inválido o expirado");
        }

        String username = jwtTokenValidator.getUsernameFromToken(token);

        return usuarioRepository.findByUsername(username)
                .filter(Usuario::Activo)
                .orElseThrow(() -> new InvalidTokenException("Usuario no encontrado o inactivo"));
    }
}
