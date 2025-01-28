package com.capitalized.repository;

import com.capitalized.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface  TransactionRepository extends CrudRepository<Transaction, UUID> {

}