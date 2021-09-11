package com.devsuperior.dsvendas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSucessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	// Veja que serviço depende de repository
	// é injectado com Autowired
	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;
//
	@Transactional( readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}

	@Transactional( readOnly = true)
	public List<SaleSucessDTO> sucessGroupedBySeller(){
		return repository.sucessGroupedBySeller();
	}

	@Transactional( readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		// o comando abaixo é para evitar dele ir várias vezes
		// como são poucos registros, vale à pena. 
		sellerRepository.findAll();

		
		// se digitar repository. 
		// e pressionar ctrl + barra, veja que mostra outros métodos do JPA
		// Veja que respository retorna uma lista basedo em Seller, conforme Seller.java
		Page<Sale> result = repository.findAll(pageable);
		
		/*
		 * Como o Pageable já é um stream, então comento o abaixo e faço
		 * conforme o return
		 * return result.stream().map( x -> new SaleDTO(x)).collect( Collectors.toList() );
		*/
		return result.map( x -> new SaleDTO(x));
				
		
	}
	
}
