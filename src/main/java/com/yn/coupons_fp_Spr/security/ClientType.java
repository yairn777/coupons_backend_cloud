package com.yn.coupons_fp_Spr.security;

public enum ClientType {
    ADMINISTRATOR("ADMINISTRATOR"),
    COMPANY("COMPANY"),
    CUSTOMER("CUSTOMER");

    private String type;

    ClientType(String type) {
        this.type = type;
    }
}
