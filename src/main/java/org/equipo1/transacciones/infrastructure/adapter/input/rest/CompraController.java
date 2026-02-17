package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.service.CompraService;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.CompraRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.CompraResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;


    @PostMapping
    public ResponseEntity<CompraResponseDto> registrarCompra(@RequestBody CompraRequestDto request) {

        CompraResponseDto response = compraService.registrarCompra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/{id}/publicar")
    public ResponseEntity<CompraResponseDto> publicarCompra(@PathVariable Integer id) {
        CompraResponseDto response = compraService.publicarCompra(id);
        return ResponseEntity.ok(response);
    }
}
