package com.bolsadeideas.springboot.app.springbootdi.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("Servicio")
@Primary
public class Servicio implements IServicio{

    public String operacion() {
        return "Hola, se ejecuto un proceso...";
    }
}
