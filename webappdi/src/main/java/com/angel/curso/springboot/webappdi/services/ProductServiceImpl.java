package com.angel.curso.springboot.webappdi.services;

import com.angel.curso.springboot.webappdi.models.Product;
import com.angel.curso.springboot.webappdi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    //  opcion 1
    @Autowired
    private ProductRepository repository;

    /*
        opcion 2
        public ProductServiceImpl(ProductRepository repository) {
            this.repository = repository;
        }

        opcion 3
        @Autowired
        public void setRepository(ProductRepository repository) {
            this.repository = repository;
        }
     */

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            Product newProduct = p.clone();
            newProduct.setPrice(price.longValue());
            return newProduct;
        }).toList();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}