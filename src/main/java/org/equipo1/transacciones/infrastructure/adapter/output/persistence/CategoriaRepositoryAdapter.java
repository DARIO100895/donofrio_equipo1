package org.equipo1.transacciones.infrastructure.adapter.output.persistence;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.out.CategoriaRepository;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CategoriaEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.jpa.CategoriaJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Component
public class CategoriaRepositoryAdapter implements CategoriaRepository {

    private final CategoriaJpaRepository categoriaJpaRepository;

    @Override
    public String obtenerNombrePorId(Integer idCategoria) {
        return categoriaJpaRepository.findById(idCategoria)
                .map(CategoriaEntity::getNombre)
                .orElse(null);
    }
}
