package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Customer;
import com.yn.coupons_fp_Spr.dto.CompanyDto;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.security.ClientType;

import java.util.List;

public interface AdminService {
    boolean login(String email, String password);
    Company addCompany(Company company) throws CouponsException;
    Company updateCompany(int company_id, Company company) throws CouponsException;
    void deleteCompany(int company_id) throws CouponsException;
    List<Company> getAllCompanies();
    Company getOneCompany(int company_id) throws CouponsException;
    Customer addCustomer(Customer customer) throws CouponsException;
    void updateCustomer(int customer_id,Customer customer) throws CouponsException;
    void deleteCustomer(int customer_id) throws CouponsException;
    List<Customer>getAllCustomers();
    Customer getOneCustomer(int customer_id) throws CouponsException;
}
