package org.equipo1.transacciones.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Venta {

    private Integer idVenta;
    private String ordenVenta;
    private LocalDate fechaVenta;
    private Integer idVendedor;
    private Integer idCliente;
    private BigDecimal total;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    private List<VentaDetalle> detalles;

    //Constructor principal
    public Venta(Integer idVenta, String ordenVenta, LocalDate fechaVenta, Integer idVendedor, Integer idCliente) {

        this.idVenta = idVenta;
        this.ordenVenta = Objects.requireNonNull(ordenVenta);
        this.fechaVenta = Objects.requireNonNull(fechaVenta);
        this.idVendedor = Objects.requireNonNull(idVendedor);
        this.idCliente = Objects.requireNonNull(idCliente);
        this.total = BigDecimal.ZERO;
        this.estado = "PENDIENTE";
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
        this.detalles = new ArrayList<>();
    }

    //Metodos de negocio

    public void agregarDetalle(VentaDetalle detalle) {
        Objects.requireNonNull(detalle);
        this.detalles.add(detalle);
        CalcularTotal();
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = Objects.requireNonNull(nuevoEstado);
        this.fechaActualizacion = LocalDateTime.now();
    }

    private void CalcularTotal() {
        this.total = detalles.stream()
                .map(VentaDetalle::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Getters

    public Integer getIdVenta() { return idVenta;}
    public String getOrdenVenta() { return ordenVenta;}
    public LocalDate getFechaVenta() { return fechaVenta;}
    public Integer getIdVendedor() { return idVendedor;}
    public Integer getIdCliente() { return idCliente;}
    public BigDecimal getTotal() { return total; }
    public String getEstado() { return estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public List<VentaDetalle> getDetalles() { return detalles; }

}
