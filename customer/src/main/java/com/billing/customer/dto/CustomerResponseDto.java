package com.billing.customer.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerResponseDto implements Serializable {
    private String title;
    private String firstName;
    private String lastName;
    private String address;


    @Override
    public String toString() {
        return "CustomerResponseDto {" +
                "title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
