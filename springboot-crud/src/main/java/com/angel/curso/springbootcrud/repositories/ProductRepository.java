package com.angel.curso.springbootcrud.repositories;

import com.angel.curso.springbootcrud.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select c from Product c where c.id = :id")
    Optional<Product> deleteById(Long id);
}
