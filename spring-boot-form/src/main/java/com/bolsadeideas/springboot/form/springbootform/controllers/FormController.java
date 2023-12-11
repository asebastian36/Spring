package com.bolsadeideas.springboot.form.springbootform.controllers;

import com.bolsadeideas.springboot.form.springbootform.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("user", new Usuario());
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model) {
        model.addAttribute("titulo", "Datos procesados");

        if(result.hasErrors()) return "form";

        model.addAttribute("user", usuario);
        return "resultado";
    }
}
