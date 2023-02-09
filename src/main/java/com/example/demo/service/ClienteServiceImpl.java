package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRespository;
	
	@Override
	public void saveCliente(ClienteDTO clienteDTO) {
		Cliente cliente = ClienteDTO.convertToEntity(clienteDTO);
		clienteRespository.save(cliente);
	}

	@Override
	public ClienteDTO getClienteById(Long id) {
		Optional<Cliente> cliente = clienteRespository.findById(id);
		if(cliente.isPresent()) {
			return ClienteDTO.convertToDTO(cliente.get());
		} else {
			return null;
		}
	}

	@Override
	public List<ClienteDTO> listAllClientes() {
		List<Cliente> listaClientes = clienteRespository.findAll();
		List<ClienteDTO> listaResultado = new ArrayList<>();
		for (Cliente cliente : listaClientes) {
			listaResultado.add(ClienteDTO.convertToDTO(cliente));
		}
		return listaResultado;
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRespository.deleteById(id);
	}

}
