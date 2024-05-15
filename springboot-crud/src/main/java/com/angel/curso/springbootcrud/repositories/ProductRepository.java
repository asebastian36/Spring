package com.angel.curso.springbootcrud.repositories;

import com.angel.curso.springbootcrud.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select count(c) > 0 from Product c where c.sku = :sku")
    boolean existBySku(String sku);
}
