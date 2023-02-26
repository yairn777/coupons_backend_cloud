package com.yn.coupons_fp_Spr.mapper;

import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.dto.CompanyDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<CompanyDto, Company> {


    @Override
    public CompanyDto toCompanyDto(Company company) {
        return CompanyDto.builder()
                .name(company.getName())
                .email(company.getEmail())
                .password(company.getPassword())
                .build();
    }

    @Override
    public Company toCompany(CompanyDto companyDto) {
        return Company.builder()
                .name(companyDto.getName())
                .email(companyDto.getEmail())
                .coupons(companyDto.getCoupons())
                .password(companyDto.getPassword())
                .build();
    }
}
