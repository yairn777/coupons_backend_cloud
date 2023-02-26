package com.yn.coupons_fp_Spr.dto;

import com.yn.coupons_fp_Spr.beans.Coupon;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},mappedBy = "company")
    @Singular
    private List<Coupon> coupons=new ArrayList<>();
}
