package com.angel.curso.springboot.webappdi.repositories;

import com.angel.curso.springboot.webappdi.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
@Primary
public class ProductRepositoryImpl implements ProductRepository{
    List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Laptop", 1000L),
            new Product(2L, "Monitor", 300L),
            new Product(3L, "Teclado", 150L),
            new Product(4L, "Mouse", 125L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }


    @Override
    public Product findById(Long id) {
        return data.stream().filter(p-> p.getId().equals(id)).findFirst().orElseThrow();
    }
}