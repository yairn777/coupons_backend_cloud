package com.yn.coupons_fp_Spr.controllers;

import com.yn.coupons_fp_Spr.beans.Company;
import com.yn.coupons_fp_Spr.beans.Customer;
import com.yn.coupons_fp_Spr.dto.CompanyDto;
import com.yn.coupons_fp_Spr.dto.LoginDto;
import com.yn.coupons_fp_Spr.dto.LoginResDto;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.security.TokenManager;
import com.yn.coupons_fp_Spr.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin("*")

public class AdminController {

    private final AdminService adminService;
    private final TokenManager tokenManager;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResDto login(@RequestBody LoginDto loginDto) throws CouponsException {
        if (!adminService.login(loginDto.getEmail(), loginDto.getPassword())) {
            throw new CouponsException(ErrMsg.INVALID_EMAIL_OR_PASSWORD);
        }
        return tokenManager.add(999, loginDto.getEmail(), loginDto.getPassword(),loginDto.getClientType());
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestHeader("Authorization") UUID token, @RequestBody Company company) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.addCompany(company);
    }


    @DeleteMapping("delete_company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestHeader("Authorization") UUID token, @PathVariable int id) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        adminService.deleteCompany(id);
    }


    @PutMapping("update_company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Company updateCompany(@RequestHeader("Authorization") UUID token, @PathVariable int id, @RequestBody Company company) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.updateCompany(id, company);
    }


    @GetMapping("/getAllCompanies")

    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.getAllCompanies();
    }


    @GetMapping("/getCompanyById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company companyById(@RequestHeader("Authorization") UUID token, @PathVariable int id) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.getOneCompany(id);
    }

    @PostMapping("/addCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestHeader("Authorization") UUID token, @RequestBody Customer customer) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.addCustomer(customer);

    }

    @DeleteMapping("/deleteCustomer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestHeader("Authorization") UUID token, @PathVariable int id) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        adminService.deleteCustomer(id);
    }


    @GetMapping("/getAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.getAllCustomers();
    }


    @GetMapping("getCustomerById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer customerById(@RequestHeader("Authorization") UUID token, @PathVariable int id) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        return adminService.getOneCustomer(id);
    }

    @PutMapping("update_customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestHeader("Authorization") UUID token, @PathVariable int id, @RequestBody Customer customer) throws CouponsException {
        int adminId = tokenManager.getUInfoId(token);

        adminService.updateCustomer(id, customer);
    }


}
