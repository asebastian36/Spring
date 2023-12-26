package com.angel.curso.springboot.webappdi.services;

import com.angel.curso.springboot.webappdi.models.Product;
import com.angel.curso.springboot.webappdi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    //  opcion 1
    //  @Qualifier("productRepositoryFoo")
    @Autowired
    private ProductRepository repository;

    @Value("${config.price.tax}")
    private Double tax;

    /*
        opcion 2
        public ProductServiceImpl(@Qualifier("productRepositoryFoo")ProductRepository repository) {
            this.repository = repository;
        }

        opcion 3
        @Autowired
        @Qualifier("productRepositoryFoo")
        public void setRepository(ProductRepository repository) {
            this.repository = repository;
        }
     */

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * tax;
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