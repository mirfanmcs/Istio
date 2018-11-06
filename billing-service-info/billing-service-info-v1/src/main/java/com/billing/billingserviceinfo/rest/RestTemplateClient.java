package com.billing.billingserviceinfo.rest;


import com.billing.billingserviceinfo.dto.TransactionResponseDto;
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

    @Value("${TRANSACTION_SERVICE_PORT_HTTP:9000}")  //Env variable provided by Kubernetes
    private String transactionServicePort;

    private static final String TRANSACTION_SERVICE_URL = "http://transaction";

    public List<TransactionResponseDto> getTransactions(String accountId) {
        TransactionResponseDto[] TransactionResponseDtos = restTemplate.getForObject(TRANSACTION_SERVICE_URL + ":" + transactionServicePort + "/" + accountId, TransactionResponseDto[].class);

        return Arrays.asList(TransactionResponseDtos);

    }
}
