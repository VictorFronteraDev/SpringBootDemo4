package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.DireccionDTO;
import com.example.demo.model.Direccion;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DireccionesRepository;

@Service
public class DireccionServiceImpl implements DireccionesService{
	@Autowired
	private DireccionesRepository direccionesRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<DireccionDTO> listarDireccionesByIdCliente(ClienteDTO clienteDTO) {
		List<Direccion> listaDirecciones = (List<Direccion>) direccionesRepository.getDireccionesByIdCliente(clienteDTO.getIdCliente());
		List<DireccionDTO> listaResultados = new ArrayList<>();
		
		for (Direccion direccion : listaDirecciones) {
			listaResultados.add(DireccionDTO.convertToDTO(direccion, clienteDTO)) ;
		}
		
		return listaResultados;
	}
}
