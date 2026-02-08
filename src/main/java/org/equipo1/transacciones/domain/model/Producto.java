package org.equipo1.transacciones.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private UUID sku;
    private Integer idCategoria;
    private String nombre;
    private String presentacion;
    private Integer cantidadPorCaja;
    private String tipoEmpaque;
    private BigDecimal precio;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private List<PrecioCompraProducto> preciosCompra;
    private List<PrecioVentaProducto> preciosVenta;
}
