package com.yn.coupons_fp_Spr.exceptions;

public class CouponsException extends Exception{
    public CouponsException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }
}
