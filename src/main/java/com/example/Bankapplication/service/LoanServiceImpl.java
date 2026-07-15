package com.example.Bankapplication.service;

import com.example.Bankapplication.model.Loan;
import com.example.Bankapplication.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    @Override
    public Loan updateLoan(Long id, Loan newLoan) {

        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setCustomerId(newLoan.getCustomerId());
        loan.setLoanType(newLoan.getLoanType());
        loan.setLoanAmount(newLoan.getLoanAmount());
        loan.setInterestRate(newLoan.getInterestRate());
        loan.setLoanTenure(newLoan.getLoanTenure());
        loan.setLoanStatus(newLoan.getLoanStatus());

        return loanRepository.save(loan);
    }

    @Override
    public String deleteLoan(Long id) {
        loanRepository.deleteById(id);
        return "Loan Deleted Successfully";
    }
}
