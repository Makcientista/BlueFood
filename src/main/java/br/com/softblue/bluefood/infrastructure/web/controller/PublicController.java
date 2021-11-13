package br.com.softblue.bluefood.infrastructure.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluefood.application.ClienteService;
import br.com.softblue.bluefood.application.ValidationException;
import br.com.softblue.bluefood.domain.cliente.Cliente;
import br.com.softblue.bluefood.domain.restaurante.Restaurante;


@Controller
@RequestMapping(path = "/public") // (path = "/public") = calls classe
public class PublicController {
    
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente/new")//respond get operations in this url ("/cliente/new") = call method newCliente
	public String newCliente(Model model ) {		
		model.addAttribute("cliente", new  Cliente()); //Cliente cliente = new  Cliente(); //model.addAttribute("cleinte", cliente);
		ControllerHelper.setEditMode(model, false);
		return "cliente-cadastro";
		
	}
	
	@GetMapping("/restaurante/new")//respond get operations in this url ("/restaurante/new") = call method newCliente
	public String newRestaurante(Model model ) {		
		model.addAttribute("restaurante", new  Restaurante()); //Restaurante restaurante= new  restaurante(); //model.addAttribute("restaurante", restaurante);
		ControllerHelper.setEditMode(model, false);
		return "restaurante-cadastro";
	}
	
	
	@PostMapping(path = "/cliente/save")
	public String saveCliente(@ModelAttribute("cliente") @Valid Cliente cliente, 
			Errors errors, 
			Model model){
		
		if (!errors.hasErrors()) {
			try {
			clienteService.saveCliente(cliente);
			model.addAttribute("msg", "Cliente gravado com sucesso!");
			
		} catch (ValidationException e) {
			errors.rejectValue("email", null, e.getMessage());
		}
		}
		ControllerHelper.setEditMode(model, false);
		return "cliente-cadastro";
			}
	}
	

