package com.yn.coupons_fp_Spr.controllers;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.service.HomePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/home")
@RequiredArgsConstructor
public class HomePageController {

    private  final HomePageService homePageService;



    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getAllCoupons(){
        return homePageService.getAllCoupons();

    }

    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public  List<Coupon>couponsByCategory(@RequestParam Category category){
        return homePageService.couponsByCategory(category);
    }


    // TODO: 26/02/2023
    @GetMapping("/maxPrice")
    @ResponseStatus(HttpStatus.OK)
    public  List<Coupon>couponsByMaxPrice(@RequestParam double maxPrice){
        return null;
    }
}
