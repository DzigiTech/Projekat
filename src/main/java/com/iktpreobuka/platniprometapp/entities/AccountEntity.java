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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iktpreobuka.platniprometapp.entities.AccountEntity;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccountEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private String type;
	private String number;
	private Double state;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "client")
	@JsonManagedReference
	private ClientEntity client;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bank")
	private BankEntity bank;
	@OneToMany(mappedBy = "asender", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	private List<TransactionEntity> asender;
	@OneToMany(mappedBy = "arecipient", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	private List<TransactionEntity> arecipient;
	
	
	
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
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public BankEntity getBank() {
		return bank;
	}
	public void setBank(BankEntity bank) {
		this.bank = bank;
	}
	
	
	
	

}
