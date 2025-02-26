package com.ahmyil.account;

import java.util.HashSet;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ahmyil.account.model.Customer;
import com.ahmyil.account.repository.CustomerRepository;

@SpringBootApplication
public class AccountApplication {
	
	static CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		Customer customer = customerRepository.save(new Customer("Ahmet", "Yil"));
		System.out.println(customer);
	}

}
