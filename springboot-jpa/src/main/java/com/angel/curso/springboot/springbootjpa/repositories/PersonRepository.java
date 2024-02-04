package com.angel.curso.springboot.springbootjpa.repositories;

import com.angel.curso.springboot.springbootjpa.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
