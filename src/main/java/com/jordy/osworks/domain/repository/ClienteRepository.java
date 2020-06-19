package com.jordy.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jordy.osworks.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome(String nome); //executa find por nome
	List<Cliente> findByNomeContaining(String nome); //executa find procurando por nomes que contenham a string especifica
	Cliente findByEmail(String email);
}
