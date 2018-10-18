package com.billing.billingserviceinfo.dto;

import lombok.Data;

@Data
public class PlanDto {
    private int planAmount;
    private int dataGB;
    private int nationalCallsAmount;
    private int internationalCallsMinutes;

    @Override
    public String toString() {
        return "PlanDto {" +
                "planAmount='" + planAmount + '\'' +
                ", data='" + dataGB + '\'' +
                ", nationalCallsAmount='" + nationalCallsAmount + '\'' +
                ", internationalCallMinutes=" + internationalCallsMinutes +
                '}';
    }
}
