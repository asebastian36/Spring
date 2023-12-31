package com.angel.curso.springboot.webapperror.Services;

import com.angel.curso.springboot.webapperror.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    List<User> findAll();
}
