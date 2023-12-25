package com.angel.curso.springboot.webappdi.repositories;

import com.angel.curso.springboot.webappdi.models.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ProductRepositoryFoo implements ProductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor", 370L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor", 370L);
    }
}
