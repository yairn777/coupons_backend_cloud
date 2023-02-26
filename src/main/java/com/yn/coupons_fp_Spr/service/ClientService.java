package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.repos.CompanyRepository;
import com.yn.coupons_fp_Spr.repos.CouponRepository;
import com.yn.coupons_fp_Spr.repos.CustomerRepository;
import com.yn.coupons_fp_Spr.security.ClientType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Data
public abstract class ClientService {

    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;

    public abstract boolean login(String email, String password);
}
