package com.iktpreobuka.platniprometapp.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.platniprometapp.entities.TransactionEntity;
import com.iktpreobuka.platniprometapp.repositories.TransactionRepository;

@RestController
public class TransactionController {
	
	@Autowired
	public TransactionRepository transactionRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public TransactionEntity saveTransaction(@RequestParam Double ammount, 
		@RequestParam Date date, @RequestParam String state){
		TransactionEntity transaction = new TransactionEntity();
		transaction.setAmmount(ammount);
		transaction.setDate(date);
		transaction.setState(state);
		transactionRepository.save(transaction);
		return transaction;
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<TransactionEntity> findAllTransactions(){
		return (List<TransactionEntity>) transactionRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public TransactionEntity findTransactionById(@PathVariable Integer id){
		return transactionRepository.findOne(id);
	}

}
