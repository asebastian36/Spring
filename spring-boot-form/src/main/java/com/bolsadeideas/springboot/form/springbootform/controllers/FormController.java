package com.bolsadeideas.springboot.form.springbootform.controllers;

import com.bolsadeideas.springboot.form.springbootform.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        Usuario user = new Usuario();
        user.setApellido("Franco");
        user.setNombre("Angel");
        user.setId(1);
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        model.addAttribute("titulo", "Datos procesados");

        if(result.hasErrors()) return "form";

        model.addAttribute("user", usuario);
        status.setComplete();
        return "resultado";
    }
}
