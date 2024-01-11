package com.angel.curso.springboot.webappaop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.angel.curso.springboot.webappaop.services.*;
import java.util.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        return ResponseEntity.ok(Collections.singletonMap("greetring", greetingService.sayHello("Angel", "Hi")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {

        return ResponseEntity.ok(Collections.singletonMap("greetring", greetingService.sayHelloError("Angel", "Hi")));
    }
}
