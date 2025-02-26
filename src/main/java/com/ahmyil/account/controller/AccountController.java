package com.ahmyil.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmyil.account.dto.AccountDto;
import com.ahmyil.account.dto.CreateAccountRequest;
import com.ahmyil.account.service.AccountService;

@RequestMapping("/v1/account")
@Controller
public class AccountController {
	
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request){
		return new ResponseEntity<>(accountService.createAccount(request), HttpStatus.OK);
	}
	
	

}
