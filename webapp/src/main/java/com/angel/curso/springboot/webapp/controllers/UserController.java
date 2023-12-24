package com.angel.curso.springboot.webapp.controllers;

import com.angel.curso.springboot.webapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Angel Sebastian", "Franco Lopez", "asebastianjob@gmail.com");

        model.addAttribute("title", "Hello world");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "List");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
           new User("Angel Sebastian", "Franco Lopez", "asebastianjob@gmail.com"),
           new User("Diego Isaac", "Franco Lopez", "diego@email.com"),
           new User("Barbara", "Franco Lopez", "diego@email.com")
        );
    }
}
