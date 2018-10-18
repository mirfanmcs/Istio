package com.billing.transaction.controller;

import com.billing.transaction.dto.TransactionResponseDto;
import com.billing.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(path="/transaction/{accountId}")
    public ResponseEntity<List<TransactionResponseDto>> getTransactions(@PathVariable String accountId) {
        return new ResponseEntity<>(transactionService.getTransactions(accountId), HttpStatus.OK);
    }
}

