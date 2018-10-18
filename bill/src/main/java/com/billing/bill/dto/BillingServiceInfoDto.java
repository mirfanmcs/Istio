package com.billing.bill.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class BillingServiceInfoDto implements Serializable {
    private String serviceVersion;
    private PlanDto servicePlan;
    private PlanDto serviceUsage;
}
