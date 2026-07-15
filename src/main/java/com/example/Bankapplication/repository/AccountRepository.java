package com.example.Bankapplication.repository;

import com.example.Bankapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
    Optional<Account>findByAccountNumber(String accountNUmber);

}
