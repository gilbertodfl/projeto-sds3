package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	// Veja que serviço depende de repository
	// é injectado com Autowired
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		// se digitar repository. 
		// e pressionar ctrl + barra, veja que mostra outros métodos do JPA
		// Veja que respository retorna uma lista basedo em Seller, conforme Seller.java
		List<Seller> result = repository.findAll();
		
		return result.stream().map( x -> new SellerDTO(x))
				.collect( Collectors.toList() );
		
	}
	
}
