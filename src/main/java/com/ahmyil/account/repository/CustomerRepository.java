package com.ahmyil.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmyil.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
