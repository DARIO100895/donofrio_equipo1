package org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue
    @Column(name = "sku", columnDefinition = "UUID")
    private UUID sku;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "presentacion", length = 50)
    private String presentacion;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "cantidad_por_caja")
    private Integer cantidadPorCaja;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "activo")
    private Boolean activo = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }
        if (activo == null) {
            activo = true;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
