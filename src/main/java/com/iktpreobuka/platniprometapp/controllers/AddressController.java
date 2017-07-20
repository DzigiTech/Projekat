package com.iktpreobuka.platniprometapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.platniprometapp.entities.AddressEntity;
import com.iktpreobuka.platniprometapp.repositories.AddressRepository;

@RestController
@RequestMapping(path = "api/v1/addresses")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public AddressEntity saveAddress(@RequestParam String street, @RequestParam String city, 
			@RequestParam String country ){
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		addressRepository.save(address);
		return address;
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<AddressEntity> findAllAddresses(){
		return (List<AddressEntity>) addressRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public AddressEntity findAddressById(@PathVariable Integer id){
		return addressRepository.findOne(id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-city")
	public AddressEntity findAddressByName(@RequestParam String city){
		return addressRepository.findFirstByCity(city);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/by-country")
	public AddressEntity getClientBySurname(@RequestParam String country){
		return addressRepository.findFirstByCountry(country);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public AddressEntity updateAddress(@PathVariable Integer id, @RequestParam String street, 
			@RequestParam String city, @RequestParam String country){
		AddressEntity address = addressRepository.findOne(id);
		if(street != null){
			address.setStreet(street);
		}
		if(city != null){
			address.setCity(city);
		}
		if(country != null){
			address.setCountry(country);
		}
		addressRepository.save(address);
		return address;
	}

}
