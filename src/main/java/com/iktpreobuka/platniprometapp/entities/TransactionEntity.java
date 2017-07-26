package com.iktpreobuka.platniprometapp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TransactionEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private Double ammount;
	private Date date = new Date();
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "sender")
	private ClientEntity sender;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient")
	private ClientEntity recipient;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "asender")
	private AccountEntity asender;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "arecipient")
	private AccountEntity arecipient;
	
	public TransactionEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ClientEntity getSender() {
		return sender;
	}

	public void setSender(ClientEntity sender) {
		this.sender = sender;
	}

	public ClientEntity getRecipient() {
		return recipient;
	}

	public void setRecipient(ClientEntity recipient) {
		this.recipient = recipient;
	}

	public AccountEntity getAsender() {
		return asender;
	}

	public void setAsender(AccountEntity asender) {
		this.asender = asender;
	}

	public AccountEntity getArecipient() {
		return arecipient;
	}

	public void setArecipient(AccountEntity arecipient) {
		this.arecipient = arecipient;
	}
	
	
	
}
