package org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lista_compilada_venta")
public class ListaCompiladaVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Integer idLista;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vendedor", nullable = false)
    private VendedorEntity vendedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_territorio", nullable = false)
    private TerritorioEntity territorio;

    @Column(name = "estado", length = 20)
    private String estado = "GENERADA";

    @Column(name = "observacion", length = 200)
    private String observacion;

    @OneToMany(mappedBy = "lista", fetch = FetchType.LAZY)
    private List<ListaCompiladaClienteDetalleEntity> detalles;
}
