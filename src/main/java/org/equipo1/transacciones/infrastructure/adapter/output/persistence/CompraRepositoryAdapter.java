package org.equipo1.transacciones.infrastructure.adapter.output.persistence;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.out.CompraRepository;
import org.equipo1.transacciones.domain.model.Compra;
import org.equipo1.transacciones.domain.model.CompraDetalle;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraDetalleEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CompraEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.CompraJpaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper.CompraMapper;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompraRepositoryAdapter implements CompraRepository {

    private final CompraJpaRepository compraJpaRepository;
    private final EntityManager entityManager;

    @Override
    public Compra guardarCompra(Compra compra) {
        CompraEntity entity = CompraMapper.toEntity(compra);

        for (int i = 0; i < entity.getDetalles().size(); i++) {
            CompraDetalleEntity detalleEntity = entity.getDetalles().get(i);
            CompraDetalle detalleDomain = compra.getDetalles().get(i);


            detalleEntity.setCompra(entity);


            UUID sku = detalleDomain.getSku();
            if (sku == null) {
                throw new RuntimeException("SKU del detalle no puede ser null");
            }


            ProductoEntity productoRef = entityManager.getReference(ProductoEntity.class, sku);
            detalleEntity.setProducto(productoRef);
        }

        CompraEntity saved = compraJpaRepository.save(entity);
        return CompraMapper.toDomain(saved);
    }


    @Override
    public Compra obtenerPorId(Integer idCompra) {
        return compraJpaRepository.findById(idCompra)
                .map(CompraMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada con id: " + idCompra));
    }
}
