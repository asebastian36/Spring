package com.angel.curso.springbootcrud.services;

import java.util.List;
import com.angel.curso.springbootcrud.entities.User;

public interface UserService {

    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);
}
