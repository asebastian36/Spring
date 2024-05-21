package com.angel.curso.springbootcrud.repositories;

import com.angel.curso.springbootcrud.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
