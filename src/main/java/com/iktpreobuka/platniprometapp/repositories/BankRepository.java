package com.iktpreobuka.platniprometapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.platniprometapp.entities.BankEntity;

public interface BankRepository extends CrudRepository<BankEntity, Integer> {
		BankEntity findFirstByName(String name);
		BankEntity findFirstByPib(String pib);

}
