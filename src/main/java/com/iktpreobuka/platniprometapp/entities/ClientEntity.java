package com.iktpreobuka.platniprometapp.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "version"})
public class ClientEntity {
	
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Surname")
	private String surname;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Password")
	private String password;
	private Integer version;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	@JsonManagedReference
	@JsonProperty("Address")
	private AddressEntity address;
	@OneToMany(mappedBy = "client_accounts", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	@JsonProperty("clientaccounts")
	@JsonBackReference
	private List<AccountEntity> client_accounts;
	@OneToMany(mappedBy = "sender", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	@JsonProperty("sender transactions")
	@JsonBackReference
	private List<TransactionEntity> sender;
	@OneToMany(mappedBy = "recipient", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	@JsonProperty("recipient transactions")
	@JsonBackReference
	private List<TransactionEntity> recipient;
	
	public ClientEntity() {
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public List<TransactionEntity> getSender() {
		return sender;
	}
	public void setSender(List<TransactionEntity> sender) {
		this.sender = sender;
	}
	public List<TransactionEntity> getRecipient() {
		return recipient;
	}
	public void setRecipient(List<TransactionEntity> recipient) {
		this.recipient = recipient;
	}
	public List<AccountEntity> getClient_accounts() {
		return client_accounts;
	}
	public void setClient_accounts(List<AccountEntity> client_accounts) {
		this.client_accounts = client_accounts;
	}
	

	
	

	
	
	
	
	
	

}
