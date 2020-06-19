package com.jordy.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.osworks.domain.NegocioException;
import com.jordy.osworks.domain.model.Cliente;
import com.jordy.osworks.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar (Cliente cliente){
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("já existe um cliente com o email cadastrado.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir (Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
