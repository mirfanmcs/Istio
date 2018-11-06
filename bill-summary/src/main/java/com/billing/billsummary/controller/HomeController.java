package com.billing.billsummary.controller;

import com.billing.billsummary.dto.BillSummaryDto;
import com.billing.billsummary.service.BillSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @Autowired
    private BillSummaryService billSummaryService;

    @GetMapping(path="/{accountId}")
    public ResponseEntity<BillSummaryDto> getBillSummary(@PathVariable String accountId) {
        return new ResponseEntity<>(billSummaryService.getBillSummary(accountId), HttpStatus.OK);
    }
}

