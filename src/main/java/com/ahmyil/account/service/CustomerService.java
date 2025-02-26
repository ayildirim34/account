package com.ahmyil.account.service;

import org.springframework.stereotype.Service;

import com.ahmyil.account.exception.CustomerNotFoundException;
import com.ahmyil.account.model.Customer;
import com.ahmyil.account.repository.CustomerRepository;

@Service
public class CustomerService {

	public final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	protected Customer findCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id" + id));
	}
	
}
