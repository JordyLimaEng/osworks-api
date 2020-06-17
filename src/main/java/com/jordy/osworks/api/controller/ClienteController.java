package com.jordy.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional <Cliente> cliente = clienteRepository.findById(clienteId);		
		
		if(cliente.isPresent()) {// se houver obj na resposta
			return ResponseEntity.ok(cliente.get()); //retorna obj e código 200 - ok
		}
		
		return ResponseEntity.notFound().build();// se a resposta não tiver nada, retorna código 404 - not found
	}

}
