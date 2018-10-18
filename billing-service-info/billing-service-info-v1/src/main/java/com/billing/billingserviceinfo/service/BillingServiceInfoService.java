package com.billing.billingserviceinfo.service;


import com.billing.billingserviceinfo.dto.BillingServiceInfoDto;
import com.billing.billingserviceinfo.dto.PlanDto;
import com.billing.billingserviceinfo.dto.TransactionResponseDto;
import com.billing.billingserviceinfo.entity.Plan;
import com.billing.billingserviceinfo.repository.PlanRepository;
import com.billing.billingserviceinfo.rest.RestTemplateClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BillingServiceInfoService {

    private static final String SERVICE_VERSION = "v1";


    @Autowired
    private RestTemplateClient transactionClient;

    @Autowired
    private PlanRepository planRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public BillingServiceInfoDto getBillingServiceInfo(String accountId) {

        List<TransactionResponseDto> transactionResponseDtoList = transactionClient.getTransactions(accountId);

        Plan plan = planRepository.findPlanByAccountId(accountId);
        if (plan == null) {plan = new Plan();}

        PlanDto serviceUsage = new PlanDto();
        serviceUsage.setPlanAmount(100);
        serviceUsage.setDataGB(transactionResponseDtoList.size()*3);
        serviceUsage.setNationalCallsAmount(transactionResponseDtoList.size()*100);
        serviceUsage.setInternationalCallsMinutes(transactionResponseDtoList.size()*30);


        BillingServiceInfoDto billingServiceInfoDto = new BillingServiceInfoDto();
        billingServiceInfoDto.setServiceVersion(SERVICE_VERSION);
        billingServiceInfoDto.setServicePlan(modelMapper.map(plan, PlanDto.class));
        billingServiceInfoDto.setServiceUsage(serviceUsage);

        return billingServiceInfoDto;

    }
}
