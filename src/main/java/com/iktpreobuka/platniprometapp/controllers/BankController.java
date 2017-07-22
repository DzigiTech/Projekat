package com.iktpreobuka.platniprometapp.controllers;

/*import java.util.ArrayList;*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.platniprometapp.entities.AddressEntity;
import com.iktpreobuka.platniprometapp.entities.BankEntity;
/*import com.iktpreobuka.platniprometapp.entities.ClientEntity;*/
import com.iktpreobuka.platniprometapp.repositories.AddressRepository;
import com.iktpreobuka.platniprometapp.repositories.BankRepository;
import com.iktpreobuka.platniprometapp.repositories.ClientRepository;

@RequestMapping(path = "api/v1/banks")
@RestController
public class BankController {
	
	@Autowired
	public BankRepository bankRepository;
	@Autowired
	public AddressRepository addressRepository;
	@Autowired
	public ClientRepository clientRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public BankEntity saveBank(@RequestParam String name, 
			@RequestParam String pib ){
		BankEntity bank = new BankEntity();
		bank.setName(name);
		bank.setPib(pib);
		bankRepository.save(bank);
		return bank;
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<BankEntity> findAllBanks(){
		return (List<BankEntity>) bankRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public BankEntity findBankById(@PathVariable Integer id){
		return bankRepository.findOne(id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-name")
	public BankEntity findBankByName(@RequestParam String name){
		return bankRepository.findFirstByName(name);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-pib")
	public BankEntity getBankByPib(@RequestParam String pib){
		return bankRepository.findFirstByPib(pib);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public BankEntity updateBank(@PathVariable Integer id, @RequestParam String name, 
			@RequestParam String pib){
		BankEntity bank = bankRepository.findOne(id);
		if(name != null){
			bank.setName(name);
		}
		if(pib != null){
			bank.setPib(pib);
		}
		bankRepository.save(bank);
		return bank;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/address")
	public BankEntity assignAddressToBank(@PathVariable Integer id, @RequestParam Integer addressId){
		BankEntity bank = bankRepository.findOne(id);
		AddressEntity address = addressRepository.findOne(addressId);
		bank.setAddress(address);
		bankRepository.save(bank);
		return bank;
	}
	/*@RequestMapping(method = RequestMethod.PUT, value = "/{id}/client")
	public BankEntity assignClientToBank(@PathVariable Integer id, @RequestParam Integer clientId){
		BankEntity bank = bankRepository.findOne(id);
		ClientEntity client = clientRepository.findOne(clientId);
		List<ClientEntity> clients = new ArrayList<ClientEntity>();
		clients.add(client);
		bank.setClients(clients);
		bankRepository.save(bank);
		return bank;
	}*/
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public BankEntity deleteBank(@PathVariable Integer id){
		BankEntity bank = bankRepository.findOne(id);
		bankRepository.delete(bank);
		return bank;
	}

}
