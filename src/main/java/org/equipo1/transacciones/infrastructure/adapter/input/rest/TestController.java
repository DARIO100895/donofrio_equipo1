package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public/health")
    public Map<String, String> publicEndpoint() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Endpoint público - sin autenticación");
        return response;
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, String> adminEndpoint(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Dashboard de admin");
        response.put("usuario", authentication.getName());
        response.put("rol", authentication.getAuthorities().toString());
        return response;
    }

    @GetMapping("/almacen/inventory")
    @PreAuthorize("hasAnyRole('ADMIN', 'ALMACEN')")
    public Map<String, String> almacenEndpoint(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inventario de almacén");
        response.put("usuario", authentication.getName());
        response.put("rol", authentication.getAuthorities().toString());
        return response;
    }

    @GetMapping("/ventas/sales")
    @PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
    public Map<String, String> ventasEndpoint(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Módulo de ventas");
        response.put("usuario", authentication.getName());
        response.put("rol", authentication.getAuthorities().toString());
        return response;
    }

    @GetMapping("/protected")
    public Map<String, String> protectedEndpoint(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Endpoint protegido genérico");
        response.put("usuario", authentication.getName());
        response.put("rol", authentication.getAuthorities().toString());
        return response;
    }
}

