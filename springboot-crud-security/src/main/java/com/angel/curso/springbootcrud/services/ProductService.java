package com.angel.curso.springbootcrud.services;

import com.angel.curso.springbootcrud.entities.Product;
import java.util.*;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id, Product product);
    void deleteById(Long id);
    Optional<Product> delete(Product product);
    boolean existsBySku(String sku);
}
