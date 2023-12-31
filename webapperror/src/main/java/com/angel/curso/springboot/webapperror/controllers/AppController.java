package com.angel.curso.springboot.webapperror.controllers;

import com.angel.curso.springboot.webapperror.Services.UserService;
import com.angel.curso.springboot.webapperror.exceptions.UserNotFoundException;
import com.angel.curso.springboot.webapperror.models.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        //  simulacion de error
        //  int value = 100 / 0;

        //  otro error
        //  int value = Integer.parseInt("10x");
        return "Ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id) {
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe"));

        //  Optional<User> optional = service.findById(id);
        //  if (!optional.isEmpty()) return ResponseEntity.notFound().build();
        //  return ResponseEntity.ok(optional.get());

        return user;
    }
}
