package com.angel.curso.springboot.webappinterceptor.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/index")
    public Map<String, String> index() {
        return Collections.singletonMap("message", "handler index del controlador");
    }

    @GetMapping("/extra")
    public Map<String, String> extra() {
        return Collections.singletonMap("message", "handler extra del controlador");
    }

    @GetMapping("/finnish")
    public Map<String, String> finnish() {
        return Collections.singletonMap("message", "handler final del controlador");
    }
}
