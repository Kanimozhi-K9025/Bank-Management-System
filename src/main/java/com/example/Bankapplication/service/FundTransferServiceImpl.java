package com.example.Bankapplication.service;

import com.example.Bankapplication.entity.Account;
import com.example.Bankapplication.model.FundTransfer;
import com.example.Bankapplication.repository.AccountRepository;
import com.example.Bankapplication.repository.FundTransferRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FundTransferServiceImpl
        implements FundTransferService {

    private final AccountRepository accountRepository;
    private final FundTransferRepository transferRepository;

    public FundTransferServiceImpl(
            AccountRepository accountRepository,
            FundTransferRepository transferRepository) {

        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Override
    public FundTransfer transfer(
            Long fromAccount,
            Long toAccount,
            Double amount) {

        Account sender =
                accountRepository.findById(fromAccount)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Sender not found"));

        Account receiver =
                accountRepository.findById(toAccount)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Receiver not found"));

        if (sender.getBalance() < amount) {
            throw new RuntimeException(
                    "Insufficient balance");
        }

        sender.setBalance(
                sender.getBalance() - amount);

        receiver.setBalance(
                receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        FundTransfer transfer =
                new FundTransfer();

        transfer.setFromAccount(fromAccount);
        transfer.setToAccount(toAccount);
        transfer.setAmount(amount);
        transfer.setTransferTime(
                LocalDateTime.now());

        return transferRepository.save(transfer);
    }

    @Override
    public List<FundTransfer> getHistory() {
        return transferRepository.findAll();
    }
}
