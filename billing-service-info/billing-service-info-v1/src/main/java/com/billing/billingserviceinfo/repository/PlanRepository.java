package com.billing.billingserviceinfo.repository;

import com.billing.billingserviceinfo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {
    @Query("select p from  Plan p where p.accountId = ?1")
    Plan findPlanByAccountId(String accountId);
}
