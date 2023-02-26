//package com.yn.coupons_fp_Spr.clr;
//
//import com.yn.coupons_fp_Spr.beans.Company;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//
//
////@Component
//@Order(2)
//public class RestTest implements CommandLineRunner {
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Override
//    public void run(String... args) throws Exception {
////        Student[] students = restTemplate.getForObject("http://localhost:8080/students/getAllStudents", Student[].class);
//
//
//        Company []company=restTemplate.getForObject("http://localhost:8080/admin/getAllCompanies",Company[].class);
//        System.out.println(Arrays.toString(company)+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
//
//
//        Company company1=restTemplate.getForObject("http://localhost:8080/admin/getCompanyById/1",Company.class);
//        System.out.println(company1+"@@@@@@@@@@@@@@#$@$#%$#%");
//
//    }
//}
