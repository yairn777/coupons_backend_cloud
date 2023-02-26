package com.yn.coupons_fp_Spr.advice;

import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = {CouponsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleError(Exception e) {
        return new ErrorDetails("COUPON SYSTEM ERROR", e.getMessage());
    }

}
