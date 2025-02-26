package com.ahmyil.account.dto;

import java.time.LocalDateTime;

import com.ahmyil.account.model.TransactionType;

public class TransactionDto {
	private Long Id;
	private TransactionType transactionType;
	private double amount;
	private LocalDateTime transactionDate;

}
