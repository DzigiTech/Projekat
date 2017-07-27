package com.iktpreobuka.platniprometapp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TransactionEntity {
	@Id
	@GeneratedValue
	@JsonProperty("Id")
	private Integer id;
	@JsonProperty("Ammount")
	private Double ammount;
	@JsonProperty("Date")
	private Date date = new Date();
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "sender")
	@JsonManagedReference
	private ClientEntity sender;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient")
	@JsonManagedReference
	private ClientEntity recipient;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_account")
	private AccountEntity sender_account;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient_account")
	private AccountEntity recipient_account;
	
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
	@JsonFormat(
	shape = JsonFormat.Shape.STRING,
	pattern = "dd-MM-yyyy hh:mm:ss")
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

	public AccountEntity getSender_account() {
		return sender_account;
	}

	public void setSender_account(AccountEntity sender_account) {
		this.sender_account = sender_account;
	}

	public AccountEntity getRecipient_account() {
		return recipient_account;
	}

	public void setRecipient_account(AccountEntity recipient_account) {
		this.recipient_account = recipient_account;
	}

	
	
	
}
