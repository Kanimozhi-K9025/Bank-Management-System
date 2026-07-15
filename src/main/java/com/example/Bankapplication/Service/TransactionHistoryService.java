package com.example.Bankapplication.service;

import com.example.Bankapplication.Dto.TransactionHistoryDto;
import com.example.Bankapplication.entity.TransactionHistory;
import com.example.Bankapplication.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Bankapplication.entity.Account;
import com.example.Bankapplication.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository repository;

    // CREATE TRANSACTION (DTO → ENTITY)
    @Autowired
    private AccountRepository accountRepo;

    public TransactionHistory saveTransaction(TransactionHistoryDto dto) {

        Account account = accountRepo.findByAccountNumber(dto.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        TransactionHistory transaction = new TransactionHistory();

        transaction.setAccountNumber(dto.getAccountNumber());
        transaction.setTransactionType(dto.getTransactionType());
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setTransactionDate(LocalDateTime.now());

        String type = dto.getTransactionType().trim();
        double amount = dto.getAmount();

        if (type.equalsIgnoreCase("Deposit")) {

            account.setBalance(account.getBalance() + amount);

        }
        else if (type.equalsIgnoreCase("Withdraw")) {

            if (account.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance");
            }

            account.setBalance(account.getBalance() - amount);

        }
        else {
            throw new RuntimeException("Invalid transaction type");
        }

        accountRepo.save(account);
        return repository.save(transaction);
    }

    // GET ALL
    public List<TransactionHistory> getAllTransactions() {
        return repository.findAll();
    }

    // GET BY ID
    public Optional<TransactionHistory> getTransactionById(Long id) {
        return repository.findById(id);
    }

    // UPDATE (ENTITY BASED FOR NOW)
    public TransactionHistory updateTransaction(Long id, TransactionHistory updatedTransaction) {

        TransactionHistory existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existing.setAccountNumber(updatedTransaction.getAccountNumber());
        existing.setTransactionType(updatedTransaction.getTransactionType());
        existing.setAmount(updatedTransaction.getAmount());
        existing.setDescription(updatedTransaction.getDescription());

        return repository.save(existing);
    }

    // DELETE
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}