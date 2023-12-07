package com.bolsadeideas.springboot.app.springbootdi.controllers;

import com.bolsadeideas.springboot.app.springbootdi.models.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/app")
public class IndexController {

    //  para inyectar el servicio con la anotacion primary
    @Autowired
    private IServicio servicio;

    /*
    * para inyectar otro servicio que no tenga la anotacion primary:
    *
    * @Autowired
    * @Qualifier(""ServicioOtro)
    *private IServicio servicio;
    *
    * */

    @GetMapping({"/index", "/", ""})
    public String index(Model model) {
        model.addAttribute("servicio", servicio.operacion());
        return "index";
    }

}
