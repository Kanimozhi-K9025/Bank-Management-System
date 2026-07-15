package com.example.Bankapplication.service;

import com.example.Bankapplication.entity.Account;
import com.example.Bankapplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create Account
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get All Accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get Account By ID
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }
    //update Account
    public Account updateAccount(Long accountId, Account account) {
        account.setAccountId(accountId);
        return accountRepository.save(account);
    }

    // Delete Account
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}