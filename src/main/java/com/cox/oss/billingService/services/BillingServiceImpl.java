package com.cox.oss.billingService.services;

import com.cox.oss.billingService.Exceptions.CustomException;
import com.cox.oss.billingService.dao.BillingRepository;
import com.cox.oss.billingService.interfaces.dto.BillingDTO;
import com.cox.oss.billingService.interfaces.translators.BillingTranslator;
import com.cox.oss.billingService.services.interfaces.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    BillingRepository billingRepository;

    @Override
    public BillingDTO saveBilling(BillingDTO billing) {
        var billingEntity = BillingTranslator.convert(billing);
        return BillingTranslator.convert(billingRepository.save(billingEntity));
    }

    @Override
    public List<BillingDTO> findAll() {
        var list = billingRepository.findAll();
        return BillingTranslator.convert(list);
    }

    @Override
    public BillingDTO updateTotal(Long number, Double total)  {
        var billing = billingRepository.findByNumber(number);

        if(billing==null){
            throw new CustomException("No billings found with the number provided");
        }
        billing.setTotal(total);
        var billingEdited = billingRepository.save(billing);

        return BillingTranslator.convert(billingEdited);
    }

    @Override
    public void remove(Long number) {

        var billing = billingRepository.findByNumber(number);

        if(billing==null){
            throw new CustomException("No billings found with the number provided");
        }

        billingRepository.delete(billing);
    }

}
