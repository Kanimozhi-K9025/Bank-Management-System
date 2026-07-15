package com.example.Bankapplication.service;

import com.example.Bankapplication.model.FundTransfer;
import java.util.List;

public interface FundTransferService {

    FundTransfer transfer(
            Long fromAccount,
            Long toAccount,
            Double amount);

    List<FundTransfer> getHistory();
}
