package com.angel.curso.springbootcrud.entities;

import com.angel.curso.springbootcrud.validation.IsExistDb;
import com.angel.curso.springbootcrud.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  se establecen en los campos reglas de validacion
    @NotBlank(message = "{NotBlank.product.name}")//    cambio del mensaje predeterminado por uno personalizado
    @Size(max = 45)
    private String name;

    @Min(value = 100, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private double price;

    //  uso de validacion con anotacion personalizada
    @IsRequired
    @Size(max = 245)
    private String description;

    @IsExistDb
    @IsRequired
    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
