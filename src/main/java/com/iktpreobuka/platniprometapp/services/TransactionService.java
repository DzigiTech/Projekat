package com.iktpreobuka.platniprometapp.services;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.iktpreobuka.platniprometapp.entities.AccountEntity;
import com.iktpreobuka.platniprometapp.entities.ClientEntity;
import com.iktpreobuka.platniprometapp.entities.TransactionEntity;
import com.iktpreobuka.platniprometapp.repositories.AccountRepository;
import com.iktpreobuka.platniprometapp.repositories.ClientRepository;
import com.iktpreobuka.platniprometapp.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired 
	private ClientRepository clientRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	public TransactionEntity newTransaction(@RequestParam Double ammount, 
			@RequestParam Integer senderId, @RequestParam Integer recipientId, 
			@RequestParam Integer asenderId, @RequestParam Integer arecipientId){
		Date date = new Date();
		TransactionEntity transaction = new TransactionEntity();
		transaction.setAmmount(ammount);
		transaction.setDate(date);
		ClientEntity sender = clientRepository.findOne(senderId);
		ClientEntity recipient = clientRepository.findOne(recipientId);
		AccountEntity sender_account = accountRepository.findOne(asenderId);
		AccountEntity recipient_account = accountRepository.findOne(arecipientId);
		transaction.setSender(sender);
		transaction.setRecipient(recipient);
		transaction.setSender_account(sender_account);
		transaction.setRecipient_account(recipient_account);
		Double sstate = sender_account.getState();
		try {
			if (sstate < ammount){
				throw new Exception();
			}} catch (Exception e) {
		}
		sender_account.setState(sstate -= ammount);
		Double rstate = recipient_account.getState();
		recipient_account.setState(rstate += ammount);
		accountRepository.save(sender_account);
		accountRepository.save(recipient_account);
		transactionRepository.save(transaction);
		return transaction;
		
	}


}
