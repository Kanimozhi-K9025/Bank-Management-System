package com.example.Bankapplication.controller;

import com.example.Bankapplication.Dto.TransactionHistoryDto;
import com.example.Bankapplication.entity.TransactionHistory;
import com.example.Bankapplication.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionHistoryController {

    @Autowired
    private TransactionHistoryService service;

    // CREATE
    @PostMapping
    public TransactionHistory saveTransaction(@RequestBody TransactionHistoryDto dto) {
        return service.saveTransaction(dto);
    }

    // GET ALL
    @GetMapping
    public List<TransactionHistory> getAllTransactions() {
        return service.getAllTransactions();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Optional<TransactionHistory> getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public TransactionHistory updateTransaction(@PathVariable Long id,
                                                @RequestBody TransactionHistory transaction) {
        return service.updateTransaction(id, transaction);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);
        return "Transaction deleted successfully";
    }
}