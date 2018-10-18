package com.billing.customer.repository;


import com.billing.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from  Customer c where c.accountId = ?1")
    Customer findCustomerByAccountId(String accountId);
}


