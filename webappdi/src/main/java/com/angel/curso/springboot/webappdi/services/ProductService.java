package com.angel.curso.springboot.webappdi.services;

import com.angel.curso.springboot.webappdi.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}