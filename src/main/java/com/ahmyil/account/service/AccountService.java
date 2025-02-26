package com.ahmyil.account.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.ahmyil.account.dto.AccountDto;
import com.ahmyil.account.dto.CreateAccountRequest;
import com.ahmyil.account.model.Account;
import com.ahmyil.account.model.Customer;
import com.ahmyil.account.model.Transaction;
import com.ahmyil.account.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        // Find the customer by ID
        Customer customer = customerService.findCustomerById(createAccountRequest.getId());

        // Create a new account with the initial credit and customer
        Account account = new Account(createAccountRequest.getInitialCredit(), customer, LocalDateTime.now());

        // If the initial credit is greater than 0, create a transaction
        if (createAccountRequest.getInitialCredit() > 0) {
            Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());
            account.addTransaction(transaction);
        }

        // Save the account to the database
        Account savedAccount = accountRepository.save(account);

        // Convert the saved Account entity to an AccountDto
        return convertToAccountDto(savedAccount);
    }

    // Helper method to convert Account entity to AccountDto
    private AccountDto convertToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setBalance(account.getBalance());
        accountDto.setCreationDate(account.getCreationDate());
        accountDto.setCustomerId(account.getCustomer().getId());
        return accountDto;
    }
}