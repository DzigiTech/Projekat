package com.iktpreobuka.platniprometapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.iktpreobuka.platniprometapp.entities.TransactionEntity;
import com.iktpreobuka.platniprometapp.repositories.TransactionRepository;
import com.iktpreobuka.platniprometapp.services.TransactionService;

@RestController
@RequestMapping(path="api/v1/transactions")
@CrossOrigin
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(method = RequestMethod.POST)
	public TransactionEntity newTransaction(@RequestParam Double ammount, 
			@RequestParam Integer senderId, @RequestParam Integer recipientId, 
			@RequestParam Integer asenderId, @RequestParam Integer arecipientId){
		return transactionService.newTransaction(ammount, senderId, recipientId, asenderId, arecipientId);
				
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<TransactionEntity> findAllTransactions(){
		return (List<TransactionEntity>) transactionRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public TransactionEntity findTransactionById(@PathVariable Integer id){
		return transactionRepository.findOne(id);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public TransactionEntity deleteTransaction(@PathVariable Integer id){
		TransactionEntity transaction = transactionRepository.findOne(id);
		transactionRepository.delete(transaction);
		return transaction;
	}

}
