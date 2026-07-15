package com.example.Bankapplication.controller;

import com.example.Bankapplication.model.Account;
import com.example.Bankapplication.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository repository;

    public AccountController(
            AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Account create(
            @RequestBody Account account) {
        return repository.save(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return repository.findAll();
    }
}