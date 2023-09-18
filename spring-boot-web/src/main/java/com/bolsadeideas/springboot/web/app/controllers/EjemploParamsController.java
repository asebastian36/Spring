package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
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

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("titulo", "Recibi un parametro del Request HTTP GET - URL");
        model.addAttribute("resultado", "saludo enviado es: " + saludo + " y el numero es: " + numero);

        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;

        // Por si no recibimos un numero del parametro
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = null;
        }

        model.addAttribute("titulo", "Recibi un parametro del Request HTTP GET - URL");
        model.addAttribute("resultado", "saludo enviado es: " + saludo + " y el numero es: " + numero);

        return "params/ver";
    }
}
