package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("params")
public class EjemploParamsController {
    @GetMapping("/string")
    public String param(@RequestParam(required = false, name = "texto") String texto, Model model) {
        model.addAttribute("titulo", "Recibi un parametro del Request HTTP GET - URL");
        model.addAttribute("resultado", "texto enviado es: " + texto);
        return "params/ver";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Envio parametros");
        return "params/index";
    }
}
