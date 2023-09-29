package com.cox.oss.billingService.interfaces.translators;

import com.cox.oss.billingService.interfaces.dto.BillingDTO;
import com.cox.oss.billingService.interfaces.entities.Billing;

import java.util.List;
import java.util.stream.Collectors;

public class BillingTranslator {

    public static BillingDTO convert (Billing billing){
        return new BillingDTO(billing.getId() ,billing.getNumber(),billing.getBillingPeriod(),billing.getCustomerName(),
                billing.getTotal(),billing.getDueDate());
    }

    public static Billing convert (BillingDTO billingDTO){
        return new Billing(billingDTO.getNumber(),billingDTO.getBillingPeriod(),billingDTO.getCustomerName(),
                billingDTO.getTotal(),billingDTO.getDueDate());
    }

    public static List<BillingDTO> convert(List<Billing> billingList){

       var list = billingList.stream().map(x-> BillingTranslator.convert(x)).collect(Collectors.toList());
       return list;
    }

}
