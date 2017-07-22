package com.iktpreobuka.platniprometapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.platniprometapp.entities.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
		AccountEntity findFirstByType(String type);
		AccountEntity findFirstByNumber(String number);
		AccountEntity findFirstByState(String state);

}
