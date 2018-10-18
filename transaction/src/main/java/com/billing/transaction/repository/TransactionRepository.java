package com.billing.transaction.repository;

import com.billing.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("select t from  Transaction t where t.accountId = ?1")
    List<Transaction> findTransactionsByAccountId(String accountId);
}
