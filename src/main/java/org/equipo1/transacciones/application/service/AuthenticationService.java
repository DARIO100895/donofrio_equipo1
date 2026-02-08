package org.equipo1.transacciones.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.equipo1.transacciones.application.ports.in.AuthenticationUseCase;
import org.equipo1.transacciones.application.ports.out.UsuarioRepository;
import org.equipo1.transacciones.domain.exception.AuthenticationException;
import org.equipo1.transacciones.domain.exception.UserNotFoundException;
import org.equipo1.transacciones.domain.model.Usuario;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.AuthRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.AuthResponseDto;
import org.equipo1.transacciones.infrastructure.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService implements AuthenticationUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    @Transactional(readOnly = true)
    public AuthResponseDto authenticate(AuthRequestDto authRequestDto) {
        log.info("Iniciando autenticacion de usuario: {}", authRequestDto.getUsername());

        //Buscar usuario
        Usuario usuario = usuarioRepository.findByUsername(authRequestDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado: " + authRequestDto.getUsername()));

        //Validar password
        if(!passwordEncoder.matches(authRequestDto.getPassword(), usuario.getPasswordHash())) {
            log.warn("Contraseña incorrecta: {}", authRequestDto.getUsername());
            throw new AuthenticationException("Credenciales invalidas");
        }

        //Generar Token
        String token = jwtService.generateToken(usuario);

        log.info("Usuario Autenticado: {}", usuario.getUsername());

        return AuthResponseDto.fromToken(
                usuario.getRol().getNombreRol(),
                token
        );

    }

}
