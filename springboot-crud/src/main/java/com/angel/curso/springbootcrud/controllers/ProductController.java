package com.angel.curso.springbootcrud.controllers;

import com.angel.curso.springbootcrud.ProductValidation;
import com.angel.curso.springbootcrud.entities.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.angel.curso.springbootcrud.services.ProductService;
import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

//    @Autowired
//    private ProductValidation validation;

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> optionalProduct = service.findById(id);
        if (optionalProduct.isPresent()) return ResponseEntity.ok(optionalProduct.orElseThrow());
        return ResponseEntity.notFound().build();
    }

    //  se valida en create y update porque es donde se reciben datos, BindingResult es donde se reciben
    //  los errores para mandar los mensajes de error, nota el binding result debe estar despues del objeto a cachar
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {
        //  aqui se hace uso de la validacion personalizada
//        validation.validate(product, result);
        //  aqui se inicia la creacion de json con los mensajes de error
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product, BindingResult result, @PathVariable Long id) {
//        validation.validate(product, result);
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        Optional<Product> optionalProduct = service.update(id, product);

        if (optionalProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, product).orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Product> optionalProduct = service.findById(id);
        if (optionalProduct.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    //  metodo que genera los mensajes de error de la validacion
    private ResponseEntity<?> validation(BindingResult result) {
        //  el ? es porque la respuesta puede ser de tipo product o error en caso de fallo y asi puede recibir cualquiera de los dos tipos
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo " + error.getField() + " " +error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}
