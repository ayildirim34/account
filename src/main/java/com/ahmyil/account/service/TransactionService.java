package com.ahmyil.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ahmyil.account.model.Account;
import com.ahmyil.account.model.Transaction;
import com.ahmyil.account.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private Logger logger= LoggerFactory.getLogger(TransactionService.class);
	
	private final TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	protected Transaction initiateMoney(final Account account, double amount) {
		return transactionRepository.save(
				new Transaction(amount, account));
	}

}
