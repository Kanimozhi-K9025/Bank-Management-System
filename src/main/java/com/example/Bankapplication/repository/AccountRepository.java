package com.example.Bankapplication.repository;

import com.example.Bankapplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
}
