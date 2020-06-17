package com.jordy.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.osworks.domain.model.Cliente;
import com.jordy.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll(); // com repository já podemos retornar uma lista com os clientes sem
											// necessidade de códigos verbosos
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);

		if (cliente.isPresent()) {// se houver obj na resposta
			return ResponseEntity.ok(cliente.get()); // retorna obj e código 200 - ok
		}

		return ResponseEntity.notFound().build();// se a resposta não tiver nada, retorna código 404 - not found
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)// pode responder o código HTTP pelo proprio annotation
	public Cliente adicionar(@RequestBody Cliente cliente) {// requestBody mapeia com o spring que o corpo que vai vir
															// da requisição post vai ser do tipo cliente
		
		return clienteRepository.save(cliente);

	}

}
