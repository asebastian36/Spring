package com.bolsadeideas.springboot.app.springbootdi.models.domain;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Factura {
    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("articulosSetup")
    private List<Articulo> articulos;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
