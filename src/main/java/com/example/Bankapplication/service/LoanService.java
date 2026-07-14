package com.example.Bankapplication.service;

import com.example.Bankapplication.model.Loan;
import java.util.List;

public interface LoanService {

    Loan addLoan(Loan loan);

    List<Loan> getAllLoans();

    Loan getLoanById(Long id);

    Loan updateLoan(Long id, Loan loan);

    String deleteLoan(Long id);
}