package org.equipo1.transacciones.infrastructure.adapter.input.rest;

import org.equipo1.transacciones.application.ports.in.ProductoUseCase;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequest;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoUseCase productoUseCase;

    public ProductoController(ProductoUseCase productoUseCase) {
        this.productoUseCase = productoUseCase;
    }

    @PostMapping
    public ProductoResponse crear(@RequestBody ProductoRequest request) {

        Producto producto = productoUseCase.crearProducto(
                request.getSku(),
                request.getNombre(),
                request.getPresentacion(),
                request.getCategoria(),
                request.getCantidadPorCaja(),
                request.getPrecio()
        );

        return toResponse(producto);
    }

    @GetMapping("/{sku}")
    public ProductoResponse obtener(@PathVariable UUID sku) {
        return toResponse(productoUseCase.obtenerProducto(sku));
    }

    @DeleteMapping("/{sku}")
    public void desactivar(@PathVariable UUID sku) {
        productoUseCase.desactivarProducto(sku);
    }

    private ProductoResponse toResponse(Producto producto) {
        return ProductoResponse.builder()
                .sku(producto.getSku())
                .nombre(producto.getNombre())
                .presentacion(producto.getPresentacion())
                .categoria(producto.getCategoria())
                .cantidadPorCaja(producto.getCantidadPorCaja())
                .precio(producto.getPrecio())
                .activo(producto.getActivo())
                .fechaCreacion(producto.getFechaCreacion())
                .fechaActualizacion(producto.getFechaActualizacion())
                .build();
    }
}
