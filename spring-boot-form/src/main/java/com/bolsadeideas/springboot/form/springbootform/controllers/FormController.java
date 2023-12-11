package com.bolsadeideas.springboot.form.springbootform.controllers;

import com.bolsadeideas.springboot.form.springbootform.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
        model.addAttribute("titulo", "Datos procesados");
        model.addAttribute("user", usuario);
        return "resultado";
    }
}
