package org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compra", nullable = false)
    private CompraEntity compra;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sku", nullable = false)
    private ProductoEntity producto;

    @Column(name = "numero_lote", nullable = false, length = 20)
    private String numeroLote;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "costo_unitario", precision = 10, scale = 4, nullable = false)
    private BigDecimal costoUnitario;

    @Column(name = "subtotal", precision = 12, scale = 2)
    private BigDecimal subtotal;

    @PrePersist
    @PreUpdate
    protected void calcularSubtotal() {
        if (cantidad != null && costoUnitario != null) {
            subtotal = costoUnitario.multiply(BigDecimal.valueOf(cantidad));
        } else {
            subtotal = BigDecimal.ZERO;
        }
    }


}

