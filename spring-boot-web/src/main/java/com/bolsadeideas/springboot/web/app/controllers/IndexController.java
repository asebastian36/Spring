package com.bolsadeideas.springboot.web.app.controllers;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping(value = { "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola desde Spring framework");
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Angel");
		usuario.setApellido("Franco");
		usuario.setEmail("angelfranco@email.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Angel", "Franco", "angel@email.com"));
		usuarios.add(new Usuario("Diego", "Franco", "diego@email.com"));
		usuarios.add(new Usuario("Chucho", "Rodriguez", "chucho@email.com"));
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Angel", "Franco", "angel@email.com"));
		usuarios.add(new Usuario("Diego", "Franco", "diego@email.com"));
		usuarios.add(new Usuario("Chucho", "Rodriguez", "chucho@email.com"));
		return usuarios;
	}
}
