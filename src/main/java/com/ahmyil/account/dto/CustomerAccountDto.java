package com.ahmyil.account.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerAccountDto {
	
	private Long id;
	private double balance;
	private LocalDateTime creationTime;
	
	private Set<TransactionDto> trasactions;
	

}
