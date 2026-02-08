package org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendedor")
public class VendedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Integer idVendedor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_territorio", nullable = false)
    private TerritorioEntity territorio;

    @Column(name = "activo")
    private Boolean activo = true;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    private List<VentaEntity> ventas;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    private List<ListaCompiladaVentaEntity> listasCompiladas;
}
