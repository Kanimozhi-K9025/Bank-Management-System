package com.example.Bankapplication.controller;
import com.example.Bankapplication.Dto.FundTransferDto;


import com.example.Bankapplication.model.FundTransfer;
import com.example.Bankapplication.service.FundTransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fund_transfer")
public class FundTransferController {

    private final FundTransferService service;

    public FundTransferController(FundTransferService service) {
        this.service = service;
    }


    /*public FundTransfer transfer(
            @RequestParam Long fromAccount,
            @RequestParam Long toAccount,
            @RequestParam Double amount) {

        return service.transfer(fromAccount, toAccount, amount);
    }*/
    @PostMapping
    public FundTransfer transfer(@RequestBody FundTransferDto dto) {
        return service.transfer(
                dto.getFromAccount(),
                dto.getToAccount(),
                dto.getAmount()
        );
    }

    @GetMapping("/history")
    public List<FundTransfer> history() {
        return service.getHistory();
    }
}