package com.bolsadeideas.springboot.app.springbootdi.models.domain;

import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import java.util.List;

@Component
@RequestScope
public class Factura {
    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("articulosSetup")
    private List<Articulo> articulos;

    @PostConstruct
    public void inicializar() {
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Messi"));
        descripcion = descripcion.concat(" del cliente ").concat(cliente.getNombre());
    }

    @PreDestroy
    public void destruir() {
        System.out.println("Factura destruida");
    }

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
