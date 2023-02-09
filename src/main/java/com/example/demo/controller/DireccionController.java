package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.DireccionesService;

@Controller
public class DireccionController {
	@Autowired
	private DireccionesService direccionesService;
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("clientes/{idCliente}/direcciones")
	public String listDireccionesCliente(@PathVariable("idCliente") Long idCliente, Model model) {
		ClienteDTO clienteDTO = clienteService.getClienteById(idCliente);
		List<DireccionDTO> direcciones = direccionesService.listarDireccionesByIdCliente(clienteDTO);
		model.addAttribute("list", direcciones);
		model.addAttribute("clientedto", clienteDTO);
		
		return "direccionescliente";
	}
	

}
