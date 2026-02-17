package org.equipo1.transacciones.application.service;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.in.ProductoUseCase;
import org.equipo1.transacciones.application.ports.out.ProductoApiClient;
import org.equipo1.transacciones.application.ports.out.ProductoRepository;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.LoteDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.ProductoRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoLotesResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.ProductoResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.StockResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.output.client.ProductoClient;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.CompraDetalleJpaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper.LoteMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService implements ProductoUseCase {

    private final ProductoRepository productoRepository;
    private final ProductoApiClient productoApiClient;

    @Override
    public ProductoResponseDto crearProducto(ProductoRequestDto request) {

        Producto producto = new Producto(
                request.getIdCategoria(),
                request.getNombre(),
                request.getPresentacion(),
                request.getCantidadPorCaja(),
                request.getTipoEmpaque(),
                request.getPrecio()
        );

        Producto productoGuardado = productoRepository.guardar(producto);
        return mapToResponse(productoGuardado);
    }

    @Override
    public ProductoResponseDto obtenerProducto(UUID sku) {
        Producto producto = productoRepository.buscarPorSku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con SKU: " + sku));
        return mapToResponse(producto);
    }

    @Override
    public void desactivarProducto(UUID sku) {
        Producto producto = productoRepository.buscarPorSku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con SKU: " + sku));


        producto.desactivar();

        productoRepository.guardar(producto);
    }

    @Override
    public StockResponseDto obtenerStockProducto(UUID sku) {
        return productoApiClient.obtenerStock(sku);
    }

    @Override
    public ProductoLotesResponseDto obtenerLotesProducto(UUID sku) {
        return productoApiClient.obtenerLotes(sku);
    }

    private ProductoResponseDto mapToResponse(Producto producto) {
        return ProductoResponseDto.builder()
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