package com.iktpreobuka.platniprometapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.platniprometapp.entities.AccountEntity;
import com.iktpreobuka.platniprometapp.entities.BankEntity;
import com.iktpreobuka.platniprometapp.entities.ClientEntity;
import com.iktpreobuka.platniprometapp.repositories.AccountRepository;
import com.iktpreobuka.platniprometapp.repositories.BankRepository;
import com.iktpreobuka.platniprometapp.repositories.ClientRepository;


@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BankRepository bankRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public AccountEntity saveAccount(@RequestParam String type, 
			@RequestParam String number, @RequestParam double state){
		AccountEntity account = new AccountEntity();
		account.setType(type);
		account.setNumber(number);
		account.setState(state);
		accountRepository.save(account);
		return account;
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<AccountEntity> findAllAccounts(){
		return (List<AccountEntity>) accountRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public AccountEntity findAccountById(@PathVariable Integer id){
		return accountRepository.findOne(id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-type")
	public AccountEntity findAccountByType(@RequestParam String type){
		return accountRepository.findFirstByType(type);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-number")
	public AccountEntity findAccountByNumber(@RequestParam String number){
		return accountRepository.findFirstByNumber(number);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-state")
	public AccountEntity findAccountByState(@RequestParam String state){
		return accountRepository.findFirstByState(state);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public AccountEntity updateAccount(@PathVariable Integer id, @RequestParam String type, 
			@RequestParam String number, @RequestParam double state){
		AccountEntity account = accountRepository.findOne(id);
		if(type != null){
			account.setType(type);
		}
		if(number != null){
			account.setNumber(number);
		}
		if(state != 0){
			account.setState(state);
		}
		accountRepository.save(account);
		return account;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/client")
	public AccountEntity assignClientToAccount(@PathVariable Integer id, @RequestParam Integer clientId){
		AccountEntity account = accountRepository.findOne(id);
		ClientEntity client = clientRepository.findOne(clientId);
		account.setClient(client);
		accountRepository.save(account);
		return account;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/bank")
	public AccountEntity assignBankToAccount(@PathVariable Integer id, @RequestParam Integer bankId){
		AccountEntity account = accountRepository.findOne(id);
		BankEntity bank = bankRepository.findOne(bankId);
		account.setBank(bank);
		accountRepository.save(account);
		return account;
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public AccountEntity deleteAccount(@PathVariable Integer id){
		AccountEntity account = accountRepository.findOne(id);
		accountRepository.delete(account);
		return account;
	}

}
