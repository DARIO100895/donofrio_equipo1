package org.equipo1.transacciones.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration:86400000}")
    private Long expiration;
}
