package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.in.ProductoUseCase;
import org.equipo1.transacciones.application.ports.out.CategoriaRepository;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequest;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoUseCase productoUseCase;


    @PostMapping
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest request) {
        ProductoResponse response = productoUseCase.crearProducto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{sku}")
    public ResponseEntity<ProductoResponse> obtener(@PathVariable UUID sku) {
        ProductoResponse response = productoUseCase.obtenerProducto(sku);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> desactivar(@PathVariable UUID sku) {
        productoUseCase.desactivarProducto(sku);
        return ResponseEntity.noContent().build();
    }
}
