package com.iktpreobuka.platniprometapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.platniprometapp.entities.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

}
