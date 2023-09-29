package com.cox.oss.billingService.dao;

import com.cox.oss.billingService.interfaces.entities.Billing;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillingRepository extends JpaRepository<Billing,Long> {

    Billing findByNumber(Long number);
}
