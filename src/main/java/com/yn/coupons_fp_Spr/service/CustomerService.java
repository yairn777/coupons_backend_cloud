package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.beans.Customer;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.security.ClientType;

import java.util.List;

public interface CustomerService {

    boolean login(String email, String password);
    Coupon purchaseCoupon(int customerId,int coupon_id) throws CouponsException;
    List<Coupon>getCustomerCoupon(int customerId);
    List<Coupon>getCustomerCoupon(int customerId,Category category);
    List<Coupon>getCustomerCoupon(int customerId,double maxPrice);
    Customer customerDetails(int customerId) throws CouponsException;

    int customer_id(String email);


}
