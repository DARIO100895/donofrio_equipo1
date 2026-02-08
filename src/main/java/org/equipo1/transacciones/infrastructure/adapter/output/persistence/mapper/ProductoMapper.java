package org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper;

import org.equipo1.transacciones.domain.model.PrecioCompraProducto;
import org.equipo1.transacciones.domain.model.PrecioVentaProducto;
import org.equipo1.transacciones.domain.model.Producto;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.CategoriaEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.PrecioCompraProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.PrecioVentaProductoEntity;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.entity.ProductoEntity;

import java.util.stream.Collectors;

public class ProductoMapper {

    public static ProductoEntity toEntity(Producto producto, CategoriaEntity categoriaEntity) {
        if (producto == null) return null;

        ProductoEntity e = new ProductoEntity();
        e.setSku(producto.getSku());
        e.setNombre(producto.getNombre());
        e.setPresentacion(producto.getPresentacion());
        e.setCategoria(categoriaEntity);
        e.setCantidadPorCaja(producto.getCantidadPorCaja());
        e.setTipoEmpaque(producto.getTipoEmpaque());
        e.setPrecioUnitario(producto.getPrecio());
        e.setActivo(producto.getActivo());
        e.setFechaCreacion(producto.getFechaCreacion());
        e.setFechaActualizacion(producto.getFechaActualizacion());

        if (producto.getPreciosCompra() != null) {
            e.setPreciosCompra(
                    producto.getPreciosCompra().stream()
                            .map(p -> PrecioCompraProductoMapper.toEntity(p, e))
                            .collect(Collectors.<PrecioCompraProductoEntity>toList())
            );
        }

        if (producto.getPreciosVenta() != null) {
            e.setPreciosVenta(
                    producto.getPreciosVenta().stream()
                            .map(p -> PrecioVentaProductoMapper.toEntity(p, e))
                            .collect(Collectors.<PrecioVentaProductoEntity>toList())
            );
        }

        return e;
    }

    // De Entity a dominio
    public static Producto toDomain(ProductoEntity e) {
        if (e == null) return null;

        Producto producto = new Producto();
        producto.setSku(e.getSku());
        producto.setNombre(e.getNombre());
        producto.setPresentacion(e.getPresentacion());
        producto.setIdCategoria(e.getCategoria() != null ? e.getCategoria().getIdCategoria() : null);
        producto.setCantidadPorCaja(e.getCantidadPorCaja());
        producto.setTipoEmpaque(e.getTipoEmpaque());
        producto.setPrecio(e.getPrecioUnitario());
        producto.setActivo(e.getActivo());
        producto.setFechaCreacion(e.getFechaCreacion());
        producto.setFechaActualizacion(e.getFechaActualizacion());


        if (e.getPreciosCompra() != null) {
            producto.setPreciosCompra(
                    e.getPreciosCompra().stream()
                            .map(PrecioCompraProductoMapper::toDomain)
                            .collect(Collectors.<PrecioCompraProducto>toList())
            );
        }

        if (e.getPreciosVenta() != null) {
            producto.setPreciosVenta(
                    e.getPreciosVenta().stream()
                            .map(PrecioVentaProductoMapper::toDomain)
                            .collect(Collectors.<PrecioVentaProducto>toList())
            );
        }

        return producto;
    }
}
