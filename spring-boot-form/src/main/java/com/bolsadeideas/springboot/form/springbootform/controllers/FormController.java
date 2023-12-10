package com.bolsadeideas.springboot.form.springbootform.controllers;

import com.bolsadeideas.springboot.form.springbootform.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam String password,
                           Model model) {

        Usuario user = new Usuario();

        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        model.addAttribute("titulo", "Datos procesados");
        model.addAttribute("user", user);
        return "resultado";
    }
}
