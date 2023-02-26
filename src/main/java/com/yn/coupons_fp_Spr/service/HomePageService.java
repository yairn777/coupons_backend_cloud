package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomePageService {
    List<Coupon>getAllCoupons();
    List<Coupon>couponsByCategory(Category category);
}
