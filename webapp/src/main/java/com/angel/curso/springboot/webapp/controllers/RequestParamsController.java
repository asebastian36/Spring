package com.angel.curso.springboot.webapp.controllers;

import com.angel.curso.springboot.webapp.models.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    //  metodo para enviar un parametro a la ruta url
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola, pero que cojones haces?") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    //  metodo para enviar mas de un parametro a la ruta url
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam(required = false, defaultValue = "Pero que pelotas haces?") String message, @RequestParam() Integer code) {
        ParamMixDto param = new ParamMixDto();
        param.setMessage(message);
        param.setCode(code);

        return param;
    }

    //  metodo para enviar mas de un parametro a la ruta url pero con el objeto servlet request
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        //  mini validacion
        Integer code = 0;

        try {
            code = Integer.parseInt( request.getParameter("code") );
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
        }

        ParamMixDto param = new ParamMixDto();
        param.setMessage(request.getParameter("message"));
        param.setCode(code);

        return param;
    }
}
