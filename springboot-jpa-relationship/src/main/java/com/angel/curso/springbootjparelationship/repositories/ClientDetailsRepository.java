package com.angel.curso.springbootjparelationship.repositories;

import com.angel.curso.springbootjparelationship.entities.ClientDetails;
import org.springframework.data.repository.CrudRepository;

public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long> {
}
