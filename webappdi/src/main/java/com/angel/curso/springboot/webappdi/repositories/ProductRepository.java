package com.angel.curso.springboot.webappdi.repositories;

import com.angel.curso.springboot.webappdi.models.Product;
import java.util.*;

public class ProductRepository {
    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Laptop", 1000L),
            new Product(2L, "Monitor", 300L),
            new Product(3L, "Teclado", 150L),
            new Product(4L, "Mouse", 125L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p-> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
