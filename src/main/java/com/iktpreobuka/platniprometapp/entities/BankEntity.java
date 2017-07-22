package com.iktpreobuka.platniprometapp.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class BankEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String pib;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = 
			FetchType.LAZY)
	@JoinColumn(name = "address")
	@JsonManagedReference
	private AddressEntity address;
	@ManyToMany (cascade = CascadeType.REFRESH, fetch = 
			FetchType.LAZY)
	@JoinTable(name = "clients")
	private List<ClientEntity> clients;
	
	
	public BankEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public List<ClientEntity> getClients() {
		return clients;
	}
	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}
	
	
	
}
