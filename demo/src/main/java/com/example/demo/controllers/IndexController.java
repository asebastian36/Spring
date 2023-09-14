package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping(value = { "/index", "/", "", "/home" })
    public String index(Model model) {
        model.addAttribute("titulo", "Hola desde Spring framework");

        return "index";
    }
}
