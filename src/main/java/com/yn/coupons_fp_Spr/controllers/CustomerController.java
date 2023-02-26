package com.yn.coupons_fp_Spr.controllers;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.beans.Customer;
import com.yn.coupons_fp_Spr.dto.LoginDto;
import com.yn.coupons_fp_Spr.dto.LoginResDto;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.security.ClientType;
import com.yn.coupons_fp_Spr.security.TokenManager;
import com.yn.coupons_fp_Spr.service.CustomerService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.description.type.RecordComponentDescription;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
@CrossOrigin("*")


public class CustomerController {

    private final CustomerService customerService;
    private final TokenManager tokenManager;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResDto login(@RequestBody LoginDto loginDto) throws CouponsException {
//        System.out.println("()()()()()=>:"+email);
        if (!customerService.login(loginDto.getEmail(), loginDto.getPassword())) {
            throw new CouponsException(ErrMsg.INVALID_EMAIL_OR_PASSWORD);
        }
        int customer_id = customerService.customer_id(loginDto.getEmail());
        return tokenManager.add(customer_id, loginDto.getEmail(), loginDto.getPassword() ,loginDto.getClientType());
    }

    @PostMapping("/purchaseCoupon")
    @ResponseStatus(HttpStatus.OK)
    public Coupon purchaseCoupon(@RequestHeader("Authorization") UUID token,@RequestParam int coupon_id) throws CouponsException {
        int customer_id=tokenManager.getUInfoId(token);
      return   customerService.purchaseCoupon(customer_id,coupon_id);


    }


    @GetMapping("/customerCoupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> customerCoupons(@RequestHeader("Authorization") UUID token) throws CouponsException {
        int customer_id=tokenManager.getUInfoId(token);
        return customerService.getCustomerCoupon(customer_id);
    }


    @GetMapping("customerCouponsByCategory")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> customerCouponByCategory(@RequestHeader("Authorization") UUID token, @RequestParam Category category) throws CouponsException {
        int customer_id=tokenManager.getUInfoId(token);

        return customerService.getCustomerCoupon(customer_id,category);
    }

    @GetMapping("customerCouponsByMaxPrice")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> customerCouponsByMaxPrice(@RequestHeader("Authorization") UUID token, @RequestParam double maxPrice) throws CouponsException {
        int customer_id=tokenManager.getUInfoId(token);

        return  customerService.getCustomerCoupon(customer_id,maxPrice);
    }





    @GetMapping("customerDetails")
    @ResponseStatus(HttpStatus.OK)
    public Customer customerDetails(@RequestHeader("Authorization") UUID token) throws CouponsException {
        int customer_id=tokenManager.getUInfoId(token);

        return  customerService.customerDetails(customer_id);
    }


}
