package com.iktpreobuka.platniprometapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "version"})
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("Id")
	private Integer id;
	@JsonProperty("Street")
	private String street;
	@JsonProperty("City")
	private String city;
	@JsonProperty("Country")
	private String country;
	private Integer version;
	@OneToMany(mappedBy = "address", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<ClientEntity> clients = new ArrayList<>();
	@OneToMany(mappedBy = "address", 
			cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	@JsonBackReference
	private List<BankEntity> bankaddresses;
	
	
	public AddressEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public List<ClientEntity> getClients() {
		return clients;
	}
	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}
	public List<BankEntity> getBankaddresses() {
		return bankaddresses;
	}
	public void setBankaddresses(List<BankEntity> bankaddresses) {
		this.bankaddresses = bankaddresses;
	}
	

	
	

}
