package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Coupon;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.security.ClientType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {


    @Override
    public boolean login(String email, String password) {
        if (companyRepository.existsByEmailAndPassword(email, password)) {
            int companyId = companyRepository.companyId(email);
            return true;
        }
        return false;
    }

    @Override
    public Coupon addCoupon(int companyId, Coupon coupon) throws CouponsException, IOException {

        if (couponRepository.existsById(coupon.getId())) {
            throw new CouponsException(ErrMsg.ID_ALREADY_EXISTS);
        }
        if (couponRepository.existsTitleCouponBtCompany(companyId, coupon.getTitle()) == 1) {
            throw new CouponsException(ErrMsg.THIS_TITLE_ALREADY_EXISTS_PLEASE_CHOOSE_ANOTHER_ONE);
        }
        System.out.println("MY IMAGE: " + coupon.getImage().toString() + "===================================");
        coupon.setCompany(companyRepository.findById(companyId).orElseThrow(() -> new CouponsException(ErrMsg.ID_NOT_EXISTS)));

        return couponRepository.save(coupon);

    }


    @Override
    public Coupon updateCoupon(int companyId, int coupon_id, Coupon coupon) throws CouponsException {
        coupon.setCompany(companyDetails(companyId));
        coupon.setId(coupon_id);

        if (couponRepository.existsCouponByCompany(companyId, coupon_id) == 0) {
            throw new CouponsException(ErrMsg.ID_NOT_EXISTS);
        }
//        if (companyId!=coupon.getCompany().getId()|| (!couponRepository.existsById(coupon.getId()))){
//            throw new CouponsException((ErrMsg.YOU_CANT_CHANGE_THIS_FIELDS));
//        }

        return couponRepository.saveAndFlush(coupon);

    }

    @Override
    public void deleteCoupon(int companyId, int coupon_id) throws CouponsException {
        if (couponRepository.existsCouponByCompany(companyId, coupon_id) == 0) {
            throw new CouponsException(ErrMsg.ID_NOT_EXISTS);
        }
        couponRepository.deleteById(coupon_id);


    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId) {
        return couponRepository.getAllCompanyCoupons(companyId);
    }


    @Override
    public List<Coupon> getCompanyCouponByCompanyId(int company_id) {
        return couponRepository.getAllCompanyCoupons(company_id);
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId, String category) {
        System.out.println(couponRepository.getAllCompanyCouponsByCategory(companyId, String.valueOf(category)));
        return couponRepository.getAllCompanyCouponsByCategory(companyId, String.valueOf(category));
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId, double maxPrice) {
        return couponRepository.getAllCompanyCouponsByMaxPrice(companyId, maxPrice);
    }

    @Override
    public Company companyDetails(int companyId) throws CouponsException {
        return companyRepository.findById(companyId).orElseThrow(() -> new CouponsException(ErrMsg.ID_NOT_EXISTS));
    }

    @Override
    public int company_id(String email) {
        return companyRepository.companyId(email);
    }
}
