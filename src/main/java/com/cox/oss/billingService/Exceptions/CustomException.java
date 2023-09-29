package com.cox.oss.billingService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }
}
