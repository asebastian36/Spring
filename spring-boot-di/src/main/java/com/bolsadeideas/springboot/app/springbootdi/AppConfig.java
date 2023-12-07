package com.bolsadeideas.springboot.app.springbootdi;

import com.bolsadeideas.springboot.app.springbootdi.models.service.*;
import com.bolsadeideas.springboot.app.springbootdi.models.domain.*;
import org.springframework.context.annotation.*;
import java.util.*;

//  alternativa a usar la anotacion service
@Configuration
public class AppConfig {
    @Bean("Servicio")
    @Primary
    public IServicio registrarServicio() {
        return new Servicio();
    }

    @Bean("ServicioOtro")
    public IServicio registrarServicioOtro() {
        return new ServicioOtro();
    }

    //  aquí empieza el ejemplo de facturas
    @Bean("articulos")
    @Primary
    public List<Articulo> registrarArticulo() {
        Producto audifonos = new Producto("WH1000XM5", 6400);
        Producto teclado = new Producto("GK67", 1400);

        Articulo articulo0 = new Articulo(audifonos, 1);
        Articulo articulo1 = new Articulo(teclado, 2);

        return Arrays.asList(articulo0, articulo1);
    }

    @Bean("articulosSetup")
    public List<Articulo> registrarArticulosSetup() {
        Producto audifonos = new Producto("WH1000XM5", 6400);
        Producto teclado = new Producto("GK67", 1400);
        Producto monitor = new Producto("LG 27UL500-W", 6799);
        Producto mouse = new Producto("Logitech G603", 1299);

        Articulo articulo0 = new Articulo(audifonos, 1);
        Articulo articulo1 = new Articulo(teclado, 1);
        Articulo articulo2 = new Articulo(monitor, 2);
        Articulo articulo3 = new Articulo(mouse, 1);

        return Arrays.asList(articulo0, articulo1, articulo2, articulo3);
    }
}
