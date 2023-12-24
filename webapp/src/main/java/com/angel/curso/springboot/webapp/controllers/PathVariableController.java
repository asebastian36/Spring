package com.angel.curso.springboot.webapp.controllers;

import com.angel.curso.springboot.webapp.models.User;
import com.angel.curso.springboot.webapp.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    //  esta notacion tambien se puede usar en metodos
    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    //  forma automatica
    @Value("${config.list}")
    private String[] list;

    //  forma manual
    @Value("#{ '${config.list}'.split(',') }")
    private List<String> value;

    @Value("#{ '${config.list}' }")
    private String text;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ ${config.valuesMap} }")
    Map<String, Object> valuesMap;

    @Value("#{ ${config.valuesMap}.product }")
    String product;

    @Value("#{ ${config.valuesMap}.price }")
    Long price;

    @Autowired
    private Environment environment;

    //  enviar parametros a la ruta
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    //  enviar mas de un parametro a la ruta
    @GetMapping("/mix/{id}/{product}")
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Integer id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        System.out.println("Datos recibidos");
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.extra}") String extra) {
        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("list", list);
        json.put("extra", extra);
        json.put("value", value);
        json.put("text", text);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }

    @GetMapping("/enviroment")
    public Map<String, Object> enviroment() {
        Map<String, Object> json = new HashMap<>();
        //  devuelve las properties como string
        //  se requieren hacer conversiones
        json.put("elements", environment.getProperty("config.list"));
        json.put("list", environment.getProperty("config.list", List.class));

        return json;
    }
}
