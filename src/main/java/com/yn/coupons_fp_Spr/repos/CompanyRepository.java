package com.yn.coupons_fp_Spr.repos;

import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    boolean existsByNameOrEmail(String name,String email);

    boolean existsByName(String name);

    boolean existsByEmailAndPassword(String email,String password);


    @Query(value = "SELECT id FROM coupons_system.company where email = :email",nativeQuery = true)
    int companyId(@Param("email") String email);



}
