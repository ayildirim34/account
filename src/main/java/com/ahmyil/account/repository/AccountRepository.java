package com.ahmyil.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmyil.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
