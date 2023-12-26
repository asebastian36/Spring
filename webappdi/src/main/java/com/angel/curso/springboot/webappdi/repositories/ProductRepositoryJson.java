package com.angel.curso.springboot.webappdi.repositories;

import com.angel.curso.springboot.webappdi.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.*;
import java.io.IOException;
import java.util.*;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        readJson(resource);
    }

    public ProductRepositoryJson(Resource resource) {
        readJson(resource);
    }

    private void readJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
