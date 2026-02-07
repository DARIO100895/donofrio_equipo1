package org.equipo1.transacciones.infrastructure.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtTokenGenerator {
    public static void main(String[] args) {
        String secret = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NzA0MTk3NzEsImV4cCI6MTc3MTAyNDU3MSwianRpIjoiMzhjNThjN2UtMDM1Ny00NGYxLWJkNDgtM2IyNDZlN2IxNWUzIiwiaXNzIjoiYXBpLmV4YW1wbGUuY29tIiwic3ViIjoidXNlcl83MjM2IiwiYXVkIjoiaHR0cHM6Ly9leGFtcGxlLmNvbSJ9.E71cAhlnILALEd58EyQVUq7TiUfmu5BzrKZkRQcD91I";
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        // Token para ADMIN
        String adminToken = Jwts.builder()
                .subject("admin.user")
                .claim("role", "ADMIN")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();

        System.out.println("Token ADMIN:");
        System.out.println(adminToken);
        System.out.println();

        // Token para ALMACEN
        String almacenToken = Jwts.builder()
                .subject("almacen.user")
                .claim("role", "ALMACEN")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();

        System.out.println("Token ALMACEN:");
        System.out.println(almacenToken);
        System.out.println();

        // Token para VENDEDOR
        String vendedorToken = Jwts.builder()
                .subject("vendedor.user")
                .claim("role", "VENDEDOR")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();

        System.out.println("Token VENDEDOR:");
        System.out.println(vendedorToken);
    }
}
