package com.billing.bill.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BillDto implements Serializable {
    private CustomerResponseDto customer;
    private BillSummaryDto billSummary;
    private BillingServiceInfoDto serviceInfo;
    private List<TransactionResponseDto> transactions;
}
