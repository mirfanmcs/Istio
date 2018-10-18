package com.billing.bill.rest;


import com.billing.bill.dto.BillSummaryDto;
import com.billing.bill.dto.BillingServiceInfoDto;
import com.billing.bill.dto.CustomerResponseDto;
import com.billing.bill.dto.TransactionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;


@Component
public class RestTemplateClient {


    @Bean
    RestTemplate rest() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    private static final String CUSTOMER_SERVICE_URL = "http://customer-service:9001";
    private static final String BILL_SUMMARY_SERVICE_URL = "http://bill-summary-service:9002";
    private static final String BILLING_SERVICE_INFO_SERVICE_URL = "http://billing-service-info-service:9003";
    private static final String TRANSACTION_SERVICE_URL = "http://transaction-service:9000";

    public CustomerResponseDto getCustomer(String accountId,HttpHeaders requestHeaders) {
        return  restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/customer/" + accountId, CustomerResponseDto.class,requestHeaders);
    }

    public BillSummaryDto getBillSummary(String accountId,HttpHeaders requestHeaders) {
        return  restTemplate.getForObject(BILL_SUMMARY_SERVICE_URL + "/billsummary/" + accountId, BillSummaryDto.class,requestHeaders);
    }

    public BillingServiceInfoDto getBillingServiceInfo(String accountId, HttpHeaders requestHeaders) {
        return  restTemplate.getForObject(BILLING_SERVICE_INFO_SERVICE_URL + "/billingserviceinfo/" + accountId, BillingServiceInfoDto.class,requestHeaders);
    }

    public List<TransactionResponseDto> getTransactions(String accountId,HttpHeaders requestHeaders) {
        TransactionResponseDto[] TransactionResponseDtos = restTemplate.getForObject(TRANSACTION_SERVICE_URL + "/transaction/" + accountId, TransactionResponseDto[].class,requestHeaders);

        return Arrays.asList(TransactionResponseDtos);

    }
}
