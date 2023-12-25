package com.angel.curso.springboot.webappdi.repositories;

import com.angel.curso.springboot.webappdi.models.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}