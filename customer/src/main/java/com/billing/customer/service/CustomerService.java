package com.billing.customer.service;

import com.billing.customer.dto.CustomerResponseDto;
import com.billing.customer.entity.Customer;
import com.billing.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public CustomerResponseDto getCustomer(String accountId) {

        Customer customer = customerRepository.findCustomerByAccountId(accountId);
        if (customer == null) return new CustomerResponseDto();

        CustomerResponseDto customerResponseDto =  modelMapper.map(customer, CustomerResponseDto.class);
        return customerResponseDto;
    }
}
