package org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compra_detalle")
public class CompraDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra", nullable = false)
    private CompraEntity compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku", nullable = false)
    private ProductoEntity producto;

    @Column(name = "numero_lote", length = 20)
    private String numeroLote;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "costo_unitario")
    private Double costoUnitario;

    @Column(name = "subtotal")
    private Double subtotal;

    @PrePersist
    @PreUpdate
    protected void calcularSubtotal() {
        subtotal = (cantidad != null && costoUnitario != null) ? cantidad * costoUnitario : 0.0;
    }


}

