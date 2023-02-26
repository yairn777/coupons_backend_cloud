package com.yn.coupons_fp_Spr.service;

import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Customer;
import com.yn.coupons_fp_Spr.dto.CompanyDto;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.mapper.CompanyMapper;
import com.yn.coupons_fp_Spr.security.ClientType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ClientService implements AdminService {
    private final CompanyMapper companyMapper;

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@gmail.com") && password.equals("admin");
    }


    @Override
    public Company addCompany(Company company) throws CouponsException {
        if (companyRepository.existsById(company.getId())) {
            throw new CouponsException(ErrMsg.ID_ALREADY_EXISTS);
        }

        if (companyRepository.existsByNameOrEmail(company.getName(), company.getEmail())) {
            throw new CouponsException(ErrMsg.EMAIL_OR_PASSWORD_ALREADY_EXISTS);
        }

        return companyRepository.save(company);

    }

    @Override
    public Company updateCompany(int company_id, Company company) throws CouponsException {
        if (!companyRepository.existsById(company_id)) {
            throw new CouponsException(ErrMsg.ID_NOT_EXISTS);
        }
//        if (company_id != company.getId() || (!companyRepository.existsByName(company.getName()))) {
        if (company_id != company.getId() ) {

            throw new CouponsException((ErrMsg.YOU_CANT_CHANGE_THIS_FIELDS));
        }

       return companyRepository.saveAndFlush(company);

    }

    @Override
    public void deleteCompany(int company_id) throws CouponsException {
        if (!companyRepository.existsById(company_id)) {
            throw new CouponsException(ErrMsg.ID_NOT_EXISTS);
        }
        companyRepository.deleteById(company_id);


    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(int company_id) throws CouponsException {
        return companyRepository.findById(company_id).orElseThrow(() -> new CouponsException(ErrMsg.ID_NOT_EXISTS));
    }

    @Override
    public Customer addCustomer(Customer customer) throws CouponsException {
        if (customerRepository.existsById(customer.getId())) {
            throw new CouponsException(ErrMsg.ID_ALREADY_EXISTS);
        }
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponsException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }
        return customerRepository.save(customer);


    }

    @Override
    public void updateCustomer(int customer_id, Customer customer) throws CouponsException {
        if (!customerRepository.existsById(customer_id)) {
            throw new CouponsException(ErrMsg.ID_NOT_EXISTS);
        }
        if (customer_id != customer.getId()) {
            throw new CouponsException(ErrMsg.YOU_CANT_CHANGE_CUSTOMER_ID_FIELD);
        }
        customerRepository.saveAndFlush(customer);

    }

    @Override
    public void deleteCustomer(int customer_id) throws CouponsException {
        if (!customerRepository.existsById(customer_id)) {
            throw new CouponsException(ErrMsg.ID_NOT_EXISTS);
        }
        customerRepository.deleteById(customer_id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOneCustomer(int customer_id) throws CouponsException {
        return customerRepository.findById(customer_id).orElseThrow(() -> new CouponsException(ErrMsg.ID_NOT_EXISTS));
    }


}
