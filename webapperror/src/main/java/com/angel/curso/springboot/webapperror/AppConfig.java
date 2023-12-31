package com.angel.curso.springboot.webapperror;

import com.angel.curso.springboot.webapperror.models.domain.User;
import org.springframework.context.annotation.*;
import java.util.*;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users() {
        return Arrays.asList(
                new User(1L, "Angel Sebastian", "Franco Lopez"),
                new User(2L, "Diego Isaac", "Franco Lopez"),
                new User(3L, "Barbara", "Franco Lopez"),
                new User(4L, "Alma Delia", "Lopez Garcia"),
                new User(5L, "Cleto", "Franco Amador")
        );
    }
}
