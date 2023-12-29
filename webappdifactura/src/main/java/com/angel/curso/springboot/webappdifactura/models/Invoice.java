package com.angel.curso.springboot.webappdifactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import java.util.List;

//  @JsonIgnoreProperties({"targetSource", "advisors"})
@Component
@RequestScope
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.school}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice() {
        System.out.println("constructor");
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }

    @PostConstruct
    public void init() {
        System.out.println("postConstruct");
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Sebastian"));
        client.setLastname(client.getLastname().concat(" Lopez"));
        System.out.println(client);
        System.out.println(description);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente Invoice");
    }

    public int getTotal() {
        return items.stream()
                .map(item -> item.getImporte())
                .reduce(0, (sum, importe) -> sum + importe);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
