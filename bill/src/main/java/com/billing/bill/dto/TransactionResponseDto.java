package com.billing.bill.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public  class TransactionResponseDto implements Serializable {
    private String date;
    private String time;
    private String origin;
    private String destination;
    private String telNo;
    private String duration;


    @Override
    public String toString() {
        return "TransactionResponseDto {" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", origin=" + origin + '\'' +
                ", destination=" + destination + '\'' +
                ", telNo=" + telNo + '\'' +
                ", duration=" + duration +
                '}';
    }
}