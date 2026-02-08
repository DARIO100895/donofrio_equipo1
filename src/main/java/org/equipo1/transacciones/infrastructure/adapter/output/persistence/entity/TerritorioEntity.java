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
@Table(name = "territorio")
public class TerritorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_territorio")
    private Integer idTerritorio;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "territorio", fetch = FetchType.LAZY)
    private List<VendedorEntity> vendedores;

    @OneToMany(mappedBy = "territorio", fetch = FetchType.LAZY)
    private List<ClienteEntity> clientes;

    @OneToMany(mappedBy = "territorio", fetch = FetchType.LAZY)
    private List<ListaCompiladaVentaEntity> listasCompiladas;

}
