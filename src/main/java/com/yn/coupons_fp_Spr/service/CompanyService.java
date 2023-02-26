package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.security.ClientType;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    boolean login(String email, String password);
    Coupon addCoupon(int company_id,Coupon coupon) throws CouponsException, IOException;
    Coupon updateCoupon( int company_id,int coupon_id,Coupon coupon) throws CouponsException;
    void deleteCoupon(int company_id,int coupon_id) throws CouponsException;
    List<Coupon> getCompanyCoupons(int company_id);
    List<Coupon> getCompanyCouponByCompanyId(int company_id);
    List<Coupon>getCompanyCoupons(int company_id,String category);
    List<Coupon>getCompanyCoupons(int company_id,double maxPrice);
    Company companyDetails(int company_id) throws CouponsException;

    int company_id(String email);

}
