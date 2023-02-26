package com.yn.coupons_fp_Spr.exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {
    ID_NOT_EXISTS(""),

    ID_ALREADY_EXISTS(""),

    YOU_CANT_CHANGE_THIS_FIELDS(""),

    EMAIL_OR_PASSWORD_ALREADY_EXISTS(""),

    YOU_CANT_PURCHASE_THE_SAME_COUPON_TWICE(""),

    COUPON_SOLD_OUT(""),

    THE_COUPON_HAS_EXPIRED(""),

    EMAIL_ALREADY_EXISTS(""),

    YOU_CANT_CHANGE_CUSTOMER_ID_FIELD(""),

    THIS_TITLE_ALREADY_EXISTS_PLEASE_CHOOSE_ANOTHER_ONE(""),

    INVALID_EMAIL_OR_PASSWORD(""),

    COUPON_IS_NOT_EXISTS(""),

    INVALID_TOKEN("");

    private String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }
}
