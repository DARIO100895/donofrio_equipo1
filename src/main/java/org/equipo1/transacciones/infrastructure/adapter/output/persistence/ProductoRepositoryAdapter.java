package org.equipo1.transacciones.infrastructure.adapter.output.persistence;

import org.equipo1.transacciones.application.ports.out.ProductoRepository;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.ProductoJpaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper.ProductoMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductoRepositoryAdapter implements ProductoRepository {

    private final ProductoJpaRepository productojpaRepository;

    public ProductoRepositoryAdapter(ProductoJpaRepository jpaRepository) {
        this.productojpaRepository = jpaRepository;
    }

    @Override
    public void guardar(Producto producto) {
        ProductoEntity entity = ProductoMapper.toEntity(producto);
        productojpaRepository.save(entity);
    }

    @Override
    public Optional<Producto> buscarPorSku(UUID sku) {
        return productojpaRepository.findById(sku)
                .map(ProductoMapper::toDomain);
    }
}
