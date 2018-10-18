package com.billing.bill.service;

import com.billing.bill.dto.*;
import com.billing.bill.rest.RestTemplateClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class BillService {



    @Autowired
    private RestTemplateClient transactionClient;

    private ModelMapper modelMapper = new ModelMapper();


    public BillDto getBill(String accountId, HttpHeaders requestHeaders) {

        BillDto billDto = new BillDto();

        billDto.setCustomer(transactionClient.getCustomer(accountId,requestHeaders));
        billDto.setBillSummary(transactionClient.getBillSummary(accountId,requestHeaders));
        billDto.setServiceInfo(transactionClient.getBillingServiceInfo(accountId,requestHeaders));
        billDto.setTransactions(transactionClient.getTransactions(accountId,requestHeaders));

        return billDto;

    }
}
