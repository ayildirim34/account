package com.ahmyil.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmyil.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
