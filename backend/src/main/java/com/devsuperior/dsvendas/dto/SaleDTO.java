package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

public class SaleDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;

	private Integer visited;
	
	// negócios fechados. 
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	// Veja que aqui não há dependência aqui com existe no Sale.java
	private SellerDTO seller;

	public SaleDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
		//super();
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	public SaleDTO(Sale entity) {
		//super();
		id = entity.getId();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
		/*
		 *  PULO DO GATO:
		 *   seller é do tipo SellerDTO, como faço para converter
		 *   uma vez que entity é do tipo Sale?
		 *   Preciso do new para fazer isto conforme abaixo:
		 *   Observe que na classe Sale há o método getSeller 
		 *   Assim, consigo copiar todos os dados de 
		 */
		
		seller =  new SellerDTO( entity.getSeller());
	}
	// gets e sets para todos os campos
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVisited() {
		return visited;
	}
	public void setVisited(Integer visited) {
		this.visited = visited;
	}
	public Integer getDeals() {
		return deals;
	}
	public void setDeals(Integer deals) {
		this.deals = deals;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public SellerDTO getSeller() {
		return seller;
	}
	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
