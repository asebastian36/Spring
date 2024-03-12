package com.angel.curso.springbootjparelationship.repositories;

import com.angel.curso.springbootjparelationship.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
