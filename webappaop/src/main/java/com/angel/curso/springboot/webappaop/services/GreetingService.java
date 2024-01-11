package com.angel.curso.springboot.webappaop.services;

public interface GreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
