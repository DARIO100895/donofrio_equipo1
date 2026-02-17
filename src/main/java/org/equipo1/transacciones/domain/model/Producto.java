package org.equipo1.transacciones.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


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

    //Constructores

    public Producto(Integer idCategoria, String nombre, String presentacion, Integer cantidadPorCaja,
                    String tipoEmpaque, BigDecimal precio) {
        this.sku = UUID.randomUUID();
        this.idCategoria = Objects.requireNonNull(idCategoria);
        this.nombre = Objects.requireNonNull(nombre);
        this.presentacion = presentacion;
        this.cantidadPorCaja = cantidadPorCaja;
        this.tipoEmpaque = tipoEmpaque;
        this.precio = Objects.requireNonNull(precio);
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Producto(UUID sku, Integer idCategoria, String nombre, String presentacion,
                    Integer cantidadPorCaja, String tipoEmpaque, BigDecimal precio,
                    Boolean activo, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {

        this.sku = Objects.requireNonNull(sku);
        this.idCategoria = idCategoria;
        this.nombre = Objects.requireNonNull(nombre);
        this.presentacion = presentacion;
        this.cantidadPorCaja = cantidadPorCaja;
        this.tipoEmpaque = tipoEmpaque;
        this.precio = Objects.requireNonNull(precio);
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }


    // Métodos de negocio

    public void desactivar() {
        this.activo = false;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void actualizarPrecio(BigDecimal nuevoPrecio) {

        this.precio = Objects.requireNonNull(nuevoPrecio);
        this.fechaActualizacion = LocalDateTime.now();
    }

    public boolean estaActivo() {
        return Boolean.TRUE.equals(activo);
    }

    //Getters
    public UUID getSku() {
         return sku;}
    public Integer getIdCategoria() {
        return idCategoria;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPresentacion() {
        return presentacion;
    }
    public Integer getCantidadPorCaja() {
        return cantidadPorCaja;
    }
    public String getTipoEmpaque() {
        return tipoEmpaque;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public Boolean getActivo() {
        return activo;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

}
