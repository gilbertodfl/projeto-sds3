package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;

public class SellerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	/*
	 * O que tem de igual com entity: construct, gets e sets
	 * O que tem de diferente: 
	 * 		Possui implements Serializable
	 * 		Não possui hash equals
	 * 		Possui SellerDTO(Seller entity ) para facilitar nossa vida
	 */
	  		
	private List<Sale> sales = new ArrayList<>();
	
	public SellerDTO() {
	}
	
	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public SellerDTO(Seller entity) {
		id   = entity.getId  ();
		name = entity.getName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
