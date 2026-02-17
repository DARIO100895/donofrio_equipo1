package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.in.ProductoUseCase;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;
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
    public ResponseEntity<ProductoResponseDto> crear(@RequestBody ProductoRequestDto request) {
        ProductoResponseDto response = productoUseCase.crearProducto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<ProductoResponseDto> obtener(@PathVariable UUID sku) {
        ProductoResponseDto response = productoUseCase.obtenerProducto(sku);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> desactivar(@PathVariable UUID sku) {
        productoUseCase.desactivarProducto(sku);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{sku}/stock")
    public ResponseEntity<StockResponseDto> getStock(@PathVariable UUID sku) {
        StockResponseDto stock = productoUseCase.obtenerStockProducto(sku);
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/{sku}/lotes")
    public ResponseEntity<ProductoLotesResponseDto> getLotes(@PathVariable UUID sku) {
        ProductoLotesResponseDto lotes = productoUseCase.obtenerLotesProducto(sku);
        return ResponseEntity.ok(lotes);
    }
}
