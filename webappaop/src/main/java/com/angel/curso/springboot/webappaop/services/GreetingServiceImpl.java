package com.angel.curso.springboot.webappaop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
    @Override
    public String sayHello(String person, String phrase) {
        String greeting = phrase + " " + person;
        System.out.println("greeting = " + greeting);
        return greeting;
    }
}
