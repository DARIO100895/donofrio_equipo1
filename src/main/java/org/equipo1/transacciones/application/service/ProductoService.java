package org.equipo1.transacciones.application.service;

import org.equipo1.transacciones.application.ports.in.ProductoUseCase;
import org.equipo1.transacciones.application.ports.out.ProductoRepository;
import org.equipo1.transacciones.domain.model.Producto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProductoService implements ProductoUseCase {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(UUID sku, String nombre, String presentacion, String categoria, Integer cantidadPorCaja, Double precio) {

        Producto producto = Producto.builder()
                .sku(sku)
                .nombre(nombre)
                .presentacion(presentacion)
                .categoria(categoria)
                .cantidadPorCaja(cantidadPorCaja)
                .precio(precio)
                .activo(true)
                .fechaCreacion(LocalDateTime.now())
                .build();

        productoRepository.guardar(producto);
        return producto;
    }

    @Override
    public Producto obtenerProducto(UUID sku) {
        return productoRepository.buscarPorSku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void desactivarProducto(UUID sku) {
        Producto producto = obtenerProducto(sku);
        producto.setActivo(false);
        producto.setFechaActualizacion(LocalDateTime.now());
        productoRepository.guardar(producto);
    }
}
