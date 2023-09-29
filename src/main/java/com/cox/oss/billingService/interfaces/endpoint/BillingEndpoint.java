package com.cox.oss.billingService.interfaces.endpoint;

import com.cox.oss.billingService.Exceptions.CustomException;
import com.cox.oss.billingService.interfaces.dto.BillingDTO;
import com.cox.oss.billingService.services.interfaces.BillingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("billings/1.0")
public class BillingEndpoint {

    @Autowired
    BillingService billingService;

    @GetMapping(value = "/search-all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Find all Billings operation")
    public ResponseEntity<List<BillingDTO>> searchAll() {

        var list = billingService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Save Billing Operation")
    public ResponseEntity<BillingDTO> create(@RequestBody BillingDTO billingDTO) {

        var billingRet = billingService.saveBilling(billingDTO);
        return new ResponseEntity<>(billingRet, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{number}/{total}"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Update billing total operation")
    public ResponseEntity<?> updateTotal(@PathVariable Long number, @PathVariable Double total) {

        try{
            var billing = billingService.updateTotal(number, total);

            return new ResponseEntity<>(billing, HttpStatus.OK);
        }
        catch(CustomException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/remove/{number}")
    @Tag(name = "Remove billing using number")
    public ResponseEntity<?> remove(@PathVariable Long number) {

        try{
            billingService.remove(number);
            return ResponseEntity.ok().build();
        }
        catch(CustomException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
