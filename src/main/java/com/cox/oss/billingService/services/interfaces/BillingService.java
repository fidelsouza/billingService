package com.cox.oss.billingService.services.interfaces;

import com.cox.oss.billingService.interfaces.dto.BillingDTO;

import java.util.Date;
import java.util.List;

public interface BillingService {
    BillingDTO saveBilling(BillingDTO billing);

    List<BillingDTO> findAll();

    BillingDTO updateTotal(Long number, Double total);

    void remove(Long number);
}
