package com.angel.curso.springboot.webappdifactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//  @JsonIgnoreProperties({"targetSource", "advisors"})
@Component
@RequestScope
public class Client {

    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}