package com.jordy.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.osworks.domain.model.Cliente;
import com.jordy.osworks.domain.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll(); // com repository já podemos retornar uma lista com os clientes sem
											// necessidade de códigos verbosos
	}
	
	@GetMapping("/clientes/{clienteId}")
	public Cliente buscar(@PathVariable Long clienteId) {
		Optional <Cliente> cliente = clienteRepository.findById(clienteId);		
		return cliente.orElse(null);// se a resposta não tiver nada, retorna null
	}

}
