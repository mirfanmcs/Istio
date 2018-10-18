package com.billing.customer.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Customer")
@Data
public class Customer implements Serializable {


    public Customer() {

    }


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name="accountId")
    private String accountId;

    @Column(name="title")
    private String title;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="address")
    private String address;


    @Override
    public String toString() {
        return "Customer {" +
                "accountId=" + accountId +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
