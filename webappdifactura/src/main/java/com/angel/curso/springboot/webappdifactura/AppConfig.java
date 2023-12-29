package com.angel.curso.springboot.webappdifactura;

import com.angel.curso.springboot.webappdifactura.models.*;
import org.springframework.context.annotation.*;
import java.util.*;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        Product monitor = new Product("Monitor LG", 370);
        Product laptop = new Product("RedmiBook 14", 1000);
        return Arrays.asList(new Item(monitor, 2), new Item(laptop, 1));
    }

    @Bean("default")
    List<Item> itemsInvoiceSchool() {
        Product bagpack = new Product("Backpack", 170);
        Product bottle = new Product("Bottle", 100);
        Product book = new Product("Programing lenguage Java", 100);
        return Arrays.asList(new Item(bagpack, 1), new Item(bottle, 2), new Item(book, 1));
    }
}
