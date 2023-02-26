package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomePageServiceImpl implements HomePageService{

    private final CouponRepository couponRepository;

    @Override
    public List<Coupon> getAllCoupons() {

        return couponRepository.findAll();
    }

    @Override
    public List<Coupon> couponsByCategory(Category category) {
        return couponRepository.findByCategory(category);
    }

    public List<Coupon> getCustomerCoupon(int customerId, Category category) {
        return couponRepository.getAllCustomerCouponsByCategory(customerId,String.valueOf(category));
    }
}
