package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@Value("${aplication.nombre}")
	private String nombreAplicacion;

	@Value("${asignatura}")
	private String nombreAsignatura;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo".concat(nombreAplicacion));
		model.addAttribute("nombreAsignatura", nombreAsignatura);
		return "index";
	}

	@RequestMapping("/clientes")
	public String listClientes(Model model) {
		model.addAttribute("list", clienteService.listAllClientes());
		return "clientes";
	}

	@RequestMapping("/clientes/new")
	public String newCliente(Model model) {
		model.addAttribute("clientedto", new ClienteDTO());
		model.addAttribute("add", true);
		return "clienteform";
	}

	@PostMapping("clientes/save")
	public String saveCliente(Model model, @ModelAttribute("clientedto") ClienteDTO clienteDTO) {
		clienteService.saveCliente(clienteDTO);
		return "redirect:/clientes";
	}

	@RequestMapping("clientes/delete/{idCliente}")
	public String deleteCliente(@PathVariable("idCliente") Long idCliente) {
		clienteService.deleteCliente(idCliente);
		return "redirect:/clientes";
	}
}
