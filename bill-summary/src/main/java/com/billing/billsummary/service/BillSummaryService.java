package com.billing.billsummary.service;

import com.billing.billsummary.dto.BillSummaryDto;
import com.billing.billsummary.dto.TransactionResponseDto;
import com.billing.billsummary.rest.RestTemplateClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BillSummaryService {



    @Autowired
    private RestTemplateClient transactionClient;

    private ModelMapper modelMapper = new ModelMapper();


    public BillSummaryDto getBillSummary(String accountId) {

        List<TransactionResponseDto> transactionResponseDtoList = transactionClient.getTransactions(accountId);

        BillSummaryDto billSummaryDto = new BillSummaryDto();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        billSummaryDto.setBillNo("00012345");
        billSummaryDto.setIssueDate(dateFormatter.format(LocalDateTime.now()));
        billSummaryDto.setBillPeriod(transactionResponseDtoList.get(0).getDate() + " to " + transactionResponseDtoList.get(transactionResponseDtoList.size()-1).getDate());
        billSummaryDto.setDueAmount(transactionResponseDtoList.size()*10);
        billSummaryDto.setDueDate(dateFormatter.format(LocalDateTime.now().plusDays(20)));

        return billSummaryDto;

    }
}
