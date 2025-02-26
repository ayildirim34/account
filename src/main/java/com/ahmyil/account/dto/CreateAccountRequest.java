package com.ahmyil.account.dto;

import lombok.Data;

@Data
public class CreateAccountRequest {
	private Long id;
	private double initialCredit;
}
