package org.equipo1.transacciones.infrastructure.adapter.output.persistence;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.out.ProductoRepository;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CategoriaEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.CategoriaJpaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.ProductoJpaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper.ProductoMapper;
import org.springframework.stereotype.Component;


import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ProductoRepositoryAdapter implements ProductoRepository {

    private final ProductoJpaRepository productojpaRepository;
    private final CategoriaJpaRepository categoriaJpaRepository;
    private final ProductoJpaRepository productoJpaRepository;


    @Override
    public Producto guardar(Producto producto) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.findById(producto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        ProductoEntity productoExistente = productoJpaRepository.findById(producto.getSku()).orElse(null);

        if(productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPresentacion(producto.getPresentacion());
            productoExistente.setCategoria(categoriaEntity);
            productoExistente.setCantidadPorCaja(producto.getCantidadPorCaja());
            productoExistente.setTipoEmpaque(producto.getTipoEmpaque());
            productoExistente.setPrecioUnitario(producto.getPrecio());
            productoExistente.setActivo(producto.getActivo());
            productoExistente.setFechaActualizacion(producto.getFechaActualizacion());

            ProductoEntity savedEntity = productoJpaRepository.save(productoExistente);
            return ProductoMapper.toDomain(savedEntity);
        } else {
            ProductoEntity newEntity = ProductoMapper.toEntity(producto, categoriaEntity);
            ProductoEntity savedEntity = productoJpaRepository.save(newEntity);
            return ProductoMapper.toDomain(savedEntity);

        }
    }

    @Override
    public Optional<Producto> buscarPorSku(UUID sku) {
        return productojpaRepository.findById(sku)
                .map(ProductoMapper::toDomain);
    }
}
