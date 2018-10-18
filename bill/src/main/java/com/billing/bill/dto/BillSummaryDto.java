package com.billing.bill.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class BillSummaryDto implements Serializable {
    private String billNo;
    private String issueDate;
    private String billPeriod;
    private float dueAmount;
    private String dueDate;

    @Override
    public String toString() {
        return "BillSummaryDto {" +
                "billNo='" + billNo + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", billPeriod='" + billPeriod + '\'' +
                ", dueAmount=" + dueAmount + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }


}
