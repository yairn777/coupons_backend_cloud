package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.beans.Customer;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.security.ClientType;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService{


    @Override
    public boolean login(String email, String password) {
        if(customerRepository.existsByEmailAndPassword(email, password)){
            int customerId=customerRepository.customer_id(email);
            return true;
        }
        return false;
    }


    @Override
    public Coupon purchaseCoupon(int customerId,int coupon_id) throws CouponsException {

        Customer customer=customerRepository.findById(customerId).orElseThrow(()->new CouponsException(ErrMsg.ID_NOT_EXISTS));
        Coupon coupon1 = couponRepository.findById(coupon_id).orElseThrow(() -> new CouponsException(ErrMsg.ID_NOT_EXISTS));

        if(couponRepository.existsCouponByCustomer(customerId,coupon_id)==1){
            throw new CouponsException(ErrMsg.YOU_CANT_PURCHASE_THE_SAME_COUPON_TWICE);
        }
        if(coupon1.getAmount()==0){
            throw new CouponsException(ErrMsg.COUPON_SOLD_OUT);
        }
        if(coupon1.getEndDate().before(Date.valueOf(LocalDate.now()))){
            throw new CouponsException(ErrMsg.THE_COUPON_HAS_EXPIRED);
        }

        customer.getCoupons().add(coupon1);
        coupon1.setAmount(coupon1.getAmount()-1);
        customerRepository.saveAndFlush(customer);
      return   couponRepository.saveAndFlush(coupon1);
    }



    @Override
    public List<Coupon> getCustomerCoupon(int customerId) {
        return couponRepository.getAllCustomerCoupons(customerId);
    }

    @Override
    public List<Coupon> getCustomerCoupon(int customerId,Category category) {
        return couponRepository.getAllCustomerCouponsByCategory(customerId,String.valueOf(category));
    }

    @Override
    public List<Coupon> getCustomerCoupon(int customerId,double maxPrice) {
        return couponRepository.couponCustomerByMaxPrice(customerId,maxPrice);
    }

    @Override
    public Customer customerDetails(int customerId) throws CouponsException {
        return customerRepository.findById(customerId).orElseThrow(()->new CouponsException(ErrMsg.ID_NOT_EXISTS));
    }

    @Override
    public int customer_id(String email) {
        return customerRepository.customer_id(email);
    }



}
