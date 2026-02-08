package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.equipo1.transacciones.application.ports.in.AuthenticationUseCase;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.AuthRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.AuthResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody AuthRequestDto authRequestDto) {

        AuthResponseDto authResponseDto = authenticationUseCase.authenticate(authRequestDto);

        return ResponseEntity.ok(authResponseDto);
    }
}
