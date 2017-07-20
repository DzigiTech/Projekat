package com.iktpreobuka.platniprometapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.platniprometapp.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
		ClientEntity findFirstByName(String name);
		ClientEntity findFirstBySurname(String surname);
		ClientEntity findFirstByEmail (String email);
}
