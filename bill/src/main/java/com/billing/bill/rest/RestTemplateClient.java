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
import org.springframework.beans.factory.annotation.Value;

@Component
public class RestTemplateClient {


    @Bean
    RestTemplate rest() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    //Injecting Environment variables

    @Value("${CUSTOMER_SERVICE_PORT:9001}")
    private String customerServicePort;

    @Value("${BILL_SUMMARY_SERVICE_PORT:9002}")
    private String billSummaryPort;

    @Value("${BILLING_SERVICE_INFO_SERVICE_PORT:9003}")
    private String billingServiceInfoPort;

    @Value("${TRANSACTION_SERVICE_PORT:9000}")
    private String transactionServicePort;


    private static final String CUSTOMER_SERVICE_URL = "http://customer-service";
    private static final String BILL_SUMMARY_SERVICE_URL = "http://bill-summary-service";
    private static final String BILLING_SERVICE_INFO_SERVICE_URL = "http://billing-service-info-service";
    private static final String TRANSACTION_SERVICE_URL = "http://transaction-service";

    public CustomerResponseDto getCustomer(String accountId,HttpHeaders requestHeaders) {
        return  restTemplate.getForObject(CUSTOMER_SERVICE_URL + ":" + customerServicePort + "/customer/" + accountId, CustomerResponseDto.class,requestHeaders);
    }

    public BillSummaryDto getBillSummary(String accountId,HttpHeaders requestHeaders) {
        return  restTemplate.getForObject(BILL_SUMMARY_SERVICE_URL + ":" + billSummaryPort + "/billsummary/" + accountId, BillSummaryDto.class,requestHeaders);
    }

    public BillingServiceInfoDto getBillingServiceInfo(String accountId, HttpHeaders requestHeaders) {
        return  restTemplate.getForObject(BILLING_SERVICE_INFO_SERVICE_URL + ":" + billingServiceInfoPort + "/billingserviceinfo/" + accountId, BillingServiceInfoDto.class,requestHeaders);
    }

    public List<TransactionResponseDto> getTransactions(String accountId,HttpHeaders requestHeaders) {
        TransactionResponseDto[] TransactionResponseDtos = restTemplate.getForObject(TRANSACTION_SERVICE_URL + ":" + transactionServicePort + "/transaction/" + accountId, TransactionResponseDto[].class,requestHeaders);

        return Arrays.asList(TransactionResponseDtos);

    }
}
