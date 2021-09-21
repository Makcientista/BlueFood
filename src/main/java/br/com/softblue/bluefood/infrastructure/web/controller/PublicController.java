package br.com.softblue.bluefood.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluefood.domain.cliente.Cliente;


@Controller
@RequestMapping(path = "/public") // (path = "/public") = calls classe
public class PublicController {
    
	@GetMapping("/cliente/new")//respond get oprations in this url ("/cliente/new") = call method newCliente
	public String newCliente(Model model ) {		
		Cliente eu = new Cliente();
		eu.setNome("Makiesse");
		
		model.addAttribute("cliente", eu); //Cliente cliente = new  Cliente(); //model.addAttribute("cleinte", cliente);
		return "cliente-cadastro";
		
	}
}
