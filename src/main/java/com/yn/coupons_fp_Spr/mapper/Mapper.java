package com.yn.coupons_fp_Spr.mapper;

public interface Mapper <CompanyDto,Company>{
    CompanyDto toCompanyDto(Company company);
    Company toCompany(CompanyDto companyDto);
}
