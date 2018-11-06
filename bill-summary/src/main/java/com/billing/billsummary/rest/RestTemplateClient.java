package com.billing.billsummary.rest;


import com.billing.billsummary.dto.TransactionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    @Value("${TRANSACTION_SERVICE_PORT:9000}")
    private String transactionServicePort;

    private static final String TRANSACTION_SERVICE_URL = "http://transaction-service";

    public List<TransactionResponseDto> getTransactions(String accountId) {
        TransactionResponseDto[] TransactionResponseDtos = restTemplate.getForObject(TRANSACTION_SERVICE_URL + ":" + transactionServicePort + "/transaction/" + accountId, TransactionResponseDto[].class);

        return Arrays.asList(TransactionResponseDtos);

    }
}
