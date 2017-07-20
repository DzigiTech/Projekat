package com.iktpreobuka.platniprometapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.platniprometapp.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
	AddressEntity findFirstByCity(String city);
	AddressEntity findFirstByCountry(String country);
}
