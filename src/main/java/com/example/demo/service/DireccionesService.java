package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;

public interface DireccionesService {
	List <DireccionDTO> listarDireccionesByIdCliente(ClienteDTO clienteDTO);

}
