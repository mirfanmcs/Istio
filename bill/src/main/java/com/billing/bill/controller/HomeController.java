package com.billing.bill.controller;

import com.billing.bill.dto.BillDto;
import com.billing.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @Autowired
    private BillService billService;

    @GetMapping(path="/bill/{accountId}")
    public ResponseEntity<BillDto> getBillSummary(@PathVariable String accountId,@RequestHeader HttpHeaders requestHeaders) {
        return new ResponseEntity<>(billService.getBill(accountId, requestHeaders), HttpStatus.OK);
    }
}

