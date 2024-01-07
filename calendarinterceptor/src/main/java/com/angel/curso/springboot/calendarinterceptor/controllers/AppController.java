package com.angel.curso.springboot.calendarinterceptor.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class AppController {

    @GetMapping("/index")
    public ResponseEntity<?> index(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Bienvenidos al sistema de atencion a clientes");
        data.put("time", new Date());
        data.put("message", request.getAttribute("message"));
        data.put("hour", request.getAttribute("hour"));
        return ResponseEntity.ok(data);
    }
}
