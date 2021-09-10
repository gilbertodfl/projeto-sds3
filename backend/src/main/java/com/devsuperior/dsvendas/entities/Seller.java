package com.devsuperior.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// vendedor
// veja video de LOMBOK se não quiser usar gets e sets

@Entity
@Table( name="tb_sellers")
public class Seller {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	/*
	 * As coleções convém já estanciar aqui
	 * Estamos usando ArrayList porque  ArrayList é uma classe 
	 * e List é uma interface e não posso instanciar uma interface
	 * Coleções agente só faz os gets, veja que está no final do arquivo. 
	 */
	
	// O nome abaixo só pode ser seller porque no Sale.java está com este nome.
	@OneToMany( mappedBy = "seller") 		
	private List<Sale> sales = new ArrayList<>();
	
	public Seller() {
	}
	
	public Seller(Long id, String name) {
		this.id = id;
		this.name = name;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Sale> getSales() {
		return sales;
	}
	
	
}
