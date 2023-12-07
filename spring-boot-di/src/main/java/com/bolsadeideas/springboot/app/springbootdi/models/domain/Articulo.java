package com.bolsadeideas.springboot.app.springbootdi.models.domain;

public class Articulo {
    private Producto producto;

    private Integer cantidad;

    public Articulo(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer calcularTotal() {
        return cantidad * producto.getPrecio();
    }
}
