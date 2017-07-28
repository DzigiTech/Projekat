package com.iktpreobuka.platniprometapp.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iktpreobuka.platniprometapp.entities.AccountEntity;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccountEntity {
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Number")
	private String number;
	@JsonProperty("State")
	private Double state;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "client_accounts")
	@JsonManagedReference
	@JsonProperty("Client")
	private ClientEntity client_accounts;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bank")
	@JsonProperty("Bank")
	private BankEntity bank;
	
	
	
	public AccountEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Double getState() {
		return state;
	}
	public void setState(Double state) {
		this.state = state;
	}
	public BankEntity getBank() {
		return bank;
	}
	public void setBank(BankEntity bank) {
		this.bank = bank;
	}
	public ClientEntity getClient_accounts() {
		return client_accounts;
	}
	public void setClient_accounts(ClientEntity client_accounts) {
		this.client_accounts = client_accounts;
	}
	
	
	
	
	
	

}
