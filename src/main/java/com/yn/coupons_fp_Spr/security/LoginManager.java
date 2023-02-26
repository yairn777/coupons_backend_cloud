package com.yn.coupons_fp_Spr.security;


import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import com.yn.coupons_fp_Spr.service.AdminService;
import com.yn.coupons_fp_Spr.service.ClientService;
import com.yn.coupons_fp_Spr.service.CompanyService;
import com.yn.coupons_fp_Spr.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    @Autowired
    AdminService adminService;

    @Autowired
    ApplicationContext ctx;


    public ClientService login(String email, String password, ClientType clientType) throws CouponsException {

        switch (clientType) {
            case ADMINISTRATOR:
                if (adminService.login(email, password)) {
                    System.out.println("WELCOME ADMINISTRATOR");
                    return (ClientService) adminService;
                }
                throw new CouponsException(ErrMsg.INVALID_EMAIL_OR_PASSWORD);


            case COMPANY:
               CompanyService companyService = ctx.getBean(CompanyService.class);
                if (companyService.login(email, password)) {
                 // System.out.println("COMPANY"+ " "+companyService.companyDetails().getName().toUpperCase()+" "+"IS BEEN LOGGED");


                    return (ClientService) companyService;
                }
                throw new CouponsException(ErrMsg.INVALID_EMAIL_OR_PASSWORD);

            case CUSTOMER:
                CustomerService customerService=ctx.getBean(CustomerService.class);
                if(customerService.login(email, password)){
                   // System.out.println("CUSTOMER"+" "+customerService.customerDetails().getFirstName().toUpperCase()+" "+"IS BEEN LOGGED");

                    return (ClientService) customerService;
                }
                throw new CouponsException(ErrMsg.INVALID_EMAIL_OR_PASSWORD);



        }
        return null;

    }

}
