package org.equipo1.transacciones.application.service;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.in.ProductoUseCase;
import org.equipo1.transacciones.application.ports.out.ProductoRepository;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequest;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponse;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductoService implements ProductoUseCase {

    private final ProductoRepository productoRepository;

    @Override
    public ProductoResponse crearProducto(ProductoRequest request) {
        // Crear dominio Producto
        Producto producto = new Producto();
        producto.setSku(UUID.randomUUID());
        producto.setNombre(request.getNombre());
        producto.setPresentacion(request.getPresentacion());
        producto.setIdCategoria(request.getIdCategoria());
        producto.setCantidadPorCaja(request.getCantidadPorCaja());
        producto.setTipoEmpaque(request.getTipoEmpaque());
        producto.setPrecio(request.getPrecio());
        producto.setActivo(true);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaActualizacion(LocalDateTime.now());
        producto.setPreciosCompra(null);
        producto.setPreciosVenta(null);


        Producto productoGuardado = productoRepository.guardar(producto);


        return mapToResponse(productoGuardado);
    }

    @Override
    public ProductoResponse obtenerProducto(UUID sku) {
        Producto producto = productoRepository.buscarPorSku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return mapToResponse(producto);
    }

    @Override
    public void desactivarProducto(UUID sku) {
        Producto producto = productoRepository.buscarPorSku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setActivo(false);
        producto.setFechaActualizacion(LocalDateTime.now());

        productoRepository.guardar(producto);
    }


    private ProductoResponse mapToResponse(Producto producto) {
        return ProductoResponse.builder()
                .sku(producto.getSku())
                .nombre(producto.getNombre())
                .presentacion(producto.getPresentacion())
                .idCategoria(producto.getIdCategoria())
                .cantidadPorCaja(producto.getCantidadPorCaja())
                .precio(producto.getPrecio())
                .activo(producto.getActivo())
                .fechaCreacion(producto.getFechaCreacion())
                .fechaActualizacion(producto.getFechaActualizacion())
                .build();
    }
}
