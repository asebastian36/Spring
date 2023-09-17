package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariableRutaController {

    @GetMapping("/")
    public String index(Model modelo) {
        modelo.addAttribute("titulo", "Enviar parametros de la ruta");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model modelo) {
        modelo.addAttribute("titulo", "Recibi parametros de la ruta @PathVariable");
        modelo.addAttribute("resultado", "El texto enviado es: " + texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model modelo) {
        modelo.addAttribute("titulo", "Recibi parametros de la ruta @PathVariable");
        modelo.addAttribute("resultado", "El texto enviado es: " + texto + " y el numero enviado es: " + numero);
        return "variables/ver";
    }
}
