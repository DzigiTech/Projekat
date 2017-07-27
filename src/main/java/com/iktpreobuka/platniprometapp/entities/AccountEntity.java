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
import com.fasterxml.jackson.annotation.JsonProperty;
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
	@JoinColumn(name = "client_accounts")
	@JsonProperty("client")
	private ClientEntity client_accounts;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "bank")
	private BankEntity bank;
	@OneToMany(mappedBy = "sender_account", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	private List<TransactionEntity> sender_account;
	@OneToMany(mappedBy = "recipient_account", cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY)
	private List<TransactionEntity> recipient_account;
	
	
	
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
	public List<TransactionEntity> getSender_account() {
		return sender_account;
	}
	public void setSender_account(List<TransactionEntity> sender_account) {
		this.sender_account = sender_account;
	}
	public List<TransactionEntity> getRecipient_account() {
		return recipient_account;
	}
	public void setRecipient_account(List<TransactionEntity> recipient_account) {
		this.recipient_account = recipient_account;
	}
	public ClientEntity getClient_accounts() {
		return client_accounts;
	}
	public void setClient_accounts(ClientEntity client_accounts) {
		this.client_accounts = client_accounts;
	}
	
	
	
	
	
	

}
