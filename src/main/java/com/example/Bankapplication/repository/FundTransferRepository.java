package com.example.Bankapplication.repository;

import com.example.Bankapplication.model.FundTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundTransferRepository
        extends JpaRepository<FundTransfer, Long> {
}