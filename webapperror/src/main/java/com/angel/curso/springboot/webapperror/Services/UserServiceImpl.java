package com.angel.curso.springboot.webapperror.Services;

import com.angel.curso.springboot.webapperror.models.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private List<User> users;

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
