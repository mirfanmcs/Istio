package com.billing.customer.controller;

import com.billing.customer.dto.CustomerResponseDto;
import com.billing.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path="/customer/{accountId}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable String accountId) {
        return new ResponseEntity<>(customerService.getCustomer(accountId), HttpStatus.OK);
    }
}

