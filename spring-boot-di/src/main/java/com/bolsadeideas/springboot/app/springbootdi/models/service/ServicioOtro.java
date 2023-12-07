package com.bolsadeideas.springboot.app.springbootdi.models.service;

import org.springframework.stereotype.Service;

//  @Service("ServicioOtro")
public class ServicioOtro implements IServicio{
    @Override
    public String operacion() {
        return "Hola, se ejecuto OTRO proceso...";
    }
}
