package services;

import entities.Product;
import java.util.*;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    void delete(Product product);
}
