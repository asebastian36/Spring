package com.angel.curso.springboot.webapp.controllers;

import com.angel.curso.springboot.webapp.models.User;
import com.angel.curso.springboot.webapp.models.dto.UserDto;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Angel Sebastian", "Franco Lopez", "asebastianjob@gmail.com");
        Map<String, Object> model = new HashMap<>();

        model.put("title", "Hello world");
        model.put("user", user);
        return model;
    }

    @GetMapping("/details-dto")
    public UserDto detailsDto() {
        UserDto userDto = new UserDto();
        userDto.setUser(new User("Angel Sebastian", "Franco Lopez", "asebastianjob@gmail.com"));
        userDto.setTitle("Hello world");
        return userDto;
    }

    @GetMapping("/list")
    public  List<User> list() {
        User user = new User("Angel Sebastian", "Franco Lopez", "asebastianjob@gmail.com");
        User user1 = new User("Diego Isaac", "Franco Lopez", "diego@email.com");
        User user2 = new User("Barbara", "Franco Lopez", "diego@email.com");

        return Arrays.asList(user, user1, user2);
    }
}
