package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	//	alternativa: @GetMapping o @PostMapping
	
	
	//	ruta para cargar (mappear a una URL), por defecto el metodo es de tipo GET
	@GetMapping(value={"/index", "/", "/home"})
	public String index() {
		//	este debe ser el nombre de la pagina a crear
		//	en la carpeta templates
		return "index";
	}
}
