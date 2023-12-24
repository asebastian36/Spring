package com.angel.curso.springboot.webappdi.services;

import com.angel.curso.springboot.webappdi.models.Product;
import java.util.*;

public class ProductService {

    private ProductService repository;

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            p.setPrice(price.longValue());
            return p;
        }).toList();
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
