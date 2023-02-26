package com.yn.coupons_fp_Spr.controllers;


import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.dto.LoginDto;
import com.yn.coupons_fp_Spr.dto.LoginResDto;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.security.ClientType;
import com.yn.coupons_fp_Spr.security.TokenManager;
import com.yn.coupons_fp_Spr.security.UserInfo;
import com.yn.coupons_fp_Spr.service.CompanyService;
import io.swagger.annotations.ResponseHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class CompanyController {

    private final CompanyService companyService;
    private final TokenManager tokenManager;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResDto login(@RequestBody LoginDto loginDto) throws CouponsException {
        if(!companyService.login(loginDto.getEmail(), loginDto.getPassword())){
            throw new CouponsException(ErrMsg.INVALID_EMAIL_OR_PASSWORD);
        }

        int companyId=companyService.company_id(loginDto.getEmail());

        System.out.println(companyId);
        return tokenManager.add(companyId, loginDto.getEmail(), loginDto.getPassword(),loginDto.getClientType());
    }



    @PostMapping("/addCoupon")
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon addCoupon(@RequestHeader("Authorization") UUID token,@RequestBody Coupon coupon) throws CouponsException, IOException {
        int company_id=tokenManager.getUInfoId(token);
       return companyService.addCoupon(company_id,coupon);
    }



    @PutMapping("/updateCoupon")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Coupon updateCoupon(@RequestHeader("Authorization") UUID token,@RequestBody Coupon coupon) throws CouponsException {
        int company_id=tokenManager.getUInfoId(token);

         return companyService.updateCoupon(company_id,coupon.getId(),coupon);
    }




    @DeleteMapping("/deleteCoupon{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon( @RequestHeader("Authorization")UUID token,@PathVariable int id) throws CouponsException {
        int company_id=tokenManager.getUInfoId(token);

        companyService.deleteCoupon(company_id,id);

    }


    @GetMapping("/getCompaniesCoupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon>getCompanyCoupons(@RequestHeader("Authorization") UUID token) throws CouponsException {
        System.out.println("GOOD GOOD GOOD");
        System.out.println(token);
        int company_id=tokenManager.getUInfoId(token);

        return companyService.getCompanyCouponByCompanyId(company_id);
    }


//    @RequestParam(name = "name", required = false) String name
    @GetMapping("/couponsByCategory")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon>couponsByCategory(@RequestHeader("Authorization") UUID token, @RequestParam String category) throws CouponsException {
        int company_id=tokenManager.getUInfoId(token);
        System.out.println("ID: "+company_id+" "+category);
        System.out.println(category+" ()()()");



        return  companyService.getCompanyCoupons(company_id,category);
    }




    @GetMapping("couponsByMaxPrice")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon>couponsByMaxPrice(@RequestHeader("Authorization") UUID token, @RequestParam double maxPrice) throws CouponsException {
        int company_id=tokenManager.getUInfoId(token);
        System.out.println("PRICE PRICE");

        return  companyService.getCompanyCoupons(company_id,maxPrice);
    }

    @GetMapping("companyDetails")
    @ResponseStatus(HttpStatus.OK)
    public Company companyDetails(@RequestHeader("Authorization") UUID token) throws CouponsException {
        int company_id=tokenManager.getUInfoId(token);

        return companyService.companyDetails(company_id);
    }






}
