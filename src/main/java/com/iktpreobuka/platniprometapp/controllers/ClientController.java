package com.iktpreobuka.platniprometapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.platniprometapp.entities.AddressEntity;
import com.iktpreobuka.platniprometapp.entities.ClientEntity;
import com.iktpreobuka.platniprometapp.repositories.AddressRepository;
import com.iktpreobuka.platniprometapp.repositories.ClientRepository;


@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	

	@RequestMapping(method = RequestMethod.POST)
	public ClientEntity saveClient(@RequestParam String name, 
			@RequestParam String surname, @RequestParam String email, 
			@RequestParam String password){
		ClientEntity client = new ClientEntity();
		client.setName(name);
		client.setSurname(surname);
		client.setEmail(email);
		client.setPassword(password);
		clientRepository.save(client);
		return client;
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<ClientEntity> findAllClients(){
		return (List<ClientEntity>) clientRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ClientEntity findClientById(@PathVariable Integer id){
		return clientRepository.findOne(id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-name")
	public ClientEntity findClientByName(@RequestParam String name){
		return clientRepository.findFirstByName(name);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-surname")
	public ClientEntity getClientBySurname(@RequestParam String surname){
		return clientRepository.findFirstBySurname(surname);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-email")
	public ClientEntity getClientByEmail(@RequestParam String email){
		return clientRepository.findFirstByEmail(email);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ClientEntity updateClient(@PathVariable Integer id, @RequestParam String name, 
			@RequestParam String surname, @RequestParam String email){
		ClientEntity client = clientRepository.findOne(id);
		if(name != null){
			client.setName(name);
		}
		if(surname != null){
			client.setSurname(surname);
		}
		if(email != null){
			client.setEmail(email);
		}
		clientRepository.save(client);
		return client;
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/address")
	public ClientEntity assignAddressToClient(@PathVariable Integer id, @RequestParam Integer addressId){
		ClientEntity client = clientRepository.findOne(id);
		AddressEntity address = addressRepository.findOne(addressId);
		client.setAddress(address);
		clientRepository.save(client);
		return client;
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ClientEntity deleteClient(@PathVariable Integer id){
		ClientEntity client = clientRepository.findOne(id);
		clientRepository.delete(client);
		return client;
	}

}
