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


    @Override
    public Producto guardar(Producto producto) {
        CategoriaEntity categoriaEntity = categoriaJpaRepository.findById(producto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        ProductoEntity entity = ProductoMapper.toEntity(producto, categoriaEntity);

        ProductoEntity savedEntity = productojpaRepository.save(entity);

        return ProductoMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Producto> buscarPorSku(UUID sku) {
        return productojpaRepository.findById(sku)
                .map(ProductoMapper::toDomain);
    }
}
