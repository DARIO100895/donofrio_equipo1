package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.service.CompraService;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.CompraRequest;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.CompraResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;


    @PostMapping
    public ResponseEntity<CompraResponse> registrarCompra(@RequestBody CompraRequest request) {

        CompraResponse response = compraService.registrarCompra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/{id}/publicar")
    public ResponseEntity<CompraResponse> publicarCompra(@PathVariable Integer id) {
        CompraResponse response = compraService.publicarCompra(id);
        return ResponseEntity.ok(response);
    }
}
