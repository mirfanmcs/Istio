package com.billing.transaction.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Transaction")
@Data
public class Transaction implements Serializable {


    public Transaction() {

    }


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name="accountId")
    private String accountId;

    @Column(name="date")
    private String date;

    @Column(name="time")
    private String time;

    @Column(name="origin")
    private String origin;

    @Column(name="destination")
    private String destination;

    @Column(name="telNo")
    private String telNo;

    @Column(name="duration")
    private String duration;

    @Override
    public String toString() {
        return "Transaction {" +
                "accountId=" + accountId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", origin=" + origin + '\'' +
                ", destination=" + destination + '\'' +
                ", telNo=" + telNo + '\'' +
                ", duration=" + duration +
                '}';
    }
}
