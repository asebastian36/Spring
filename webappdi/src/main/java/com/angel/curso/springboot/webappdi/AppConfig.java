package com.angel.curso.springboot.webappdi;

import com.angel.curso.springboot.webappdi.repositories.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean
    @Primary
    public ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }
}
