package com.billing.billingserviceinfo.controller;

import com.billing.billingserviceinfo.dto.BillingServiceInfoDto;
import com.billing.billingserviceinfo.service.BillingServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @Autowired
    private BillingServiceInfoService billingServiceInfoService;

    @GetMapping(path="/{accountId}")
    public ResponseEntity<BillingServiceInfoDto> getBillingServiceInfo(@PathVariable String accountId) {
        return new ResponseEntity<>(billingServiceInfoService.getBillingServiceInfo(accountId), HttpStatus.OK);
    }
}

