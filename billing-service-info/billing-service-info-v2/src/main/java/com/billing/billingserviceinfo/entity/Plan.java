package com.billing.billingserviceinfo.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Plan")
@Data
public class Plan implements Serializable {


    public Plan() {

    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="accountId")
    private String accountId;

    @Column(name="planAmount")
    private int planAmount;

    @Column(name="dataGB")
    private int dataGB;

    @Column(name="nationalCallsAmount")
    private int nationalCallsAmount;

    @Column(name="internationalCallsMinutes")
    private int internationalCallsMinutes;


    @Override
    public String toString() {
        return "Plan {" +
                "accountId='" + accountId + '\'' +
                ", planAmount='" + planAmount + '\'' +
                ", data='" + dataGB + '\'' +
                ", nationalCallsAmount='" + nationalCallsAmount + '\'' +
                ", internationalCallsMinutes=" + internationalCallsMinutes +
                '}';
    }

}
