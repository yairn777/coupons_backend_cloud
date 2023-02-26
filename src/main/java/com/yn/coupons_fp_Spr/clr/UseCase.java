//package com.yn.coupons_fp_Spr.clr;
//
//import com.yn.coupons_fp_Spr.beans.Category;
//import com.yn.coupons_fp_Spr.beans.Company;
//import com.yn.coupons_fp_Spr.beans.Coupon;
//import com.yn.coupons_fp_Spr.beans.Customer;
//import com.yn.coupons_fp_Spr.repos.CompanyRepository;
//import com.yn.coupons_fp_Spr.repos.CouponRepository;
//import com.yn.coupons_fp_Spr.repos.CustomerRepository;
//import com.yn.coupons_fp_Spr.security.ClientType;
//import com.yn.coupons_fp_Spr.security.LoginManager;
//import com.yn.coupons_fp_Spr.service.AdminService;
//import com.yn.coupons_fp_Spr.service.CompanyService;
//import com.yn.coupons_fp_Spr.service.CustomerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.Arrays;
//
//
//@Component
//@Order(1)
//@RequiredArgsConstructor
//public class UseCase implements CommandLineRunner {
//    private final AdminService adminService;
//    private final CompanyRepository companyRepository;
//    private final CouponRepository couponRepository;
//    private final CustomerRepository customerRepository;
//    private final LoginManager loginManager;
//    @Autowired
//    CompanyService companyService;
//    @Autowired
//    CustomerService customerService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Company c1 = Company.builder()
//                .name("Denya")
//                .email("denya@gmail.com")
//                .password("1234")
//                .build();
//        Company c2 = Company.builder()
//                .name("Shikun-Binuy")
//                .email("shikun@gmail.com")
//                .password("2468")
//                //    .coupons(Arrays.asList(coupon1,coupon2))
//                .build();
//        Company c3 = Company.builder()
//                .name("Tidhar")
//                .email("tid@gmail.com")
//                .password("5454")
//                .build();
//        Company c4 = Company.builder()
//                .name("Ashtrom")
//                .email("ashtrom@gmail.com")
//                .password("5566")
//                .build();
//        Company c5 = Company.builder()
//                .name("Electra")
//                .email("electra@gmail.com")
//                .password("1122")
//                .build();
//
//
//        Coupon coupon1 = Coupon.builder()
//                .amount(200)
//                .category(Category.SPORT)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Chicago vs Utah")
//                .description("1+1 tickets for game number 6")
//                .price(150)
//                .company(c1)
//                .image("https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2020/03/896/500/michael-jordan-1998-Getty-Images.jpg?ve=1&tl=1")
//
//                .build();
//
//        Coupon coupon6 = Coupon.builder()
//                .amount(200)
//                .category(Category.SPORT)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Barcelona vs Real Madrid")
//                .description("1+1 tickets for El Clasico")
//                .price(250)
//                .company(c2)
//                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNJOYT0H3GhnCfoDF92lH-igx5oZwP8b2TAg&usqp=CAU")
//                .build();
//
//        Coupon coupon2 = Coupon.builder()
//                .amount(120)
//                .category(Category.FOOD)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("1+1")
//                .company(c1)
//                .description("meal for two in meatAndWine")
//                .price(180)
//                .image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5kemz-uKtHSQJUVmofVCFJWUQp2ILTlxFdw&usqp=CAU")
//
//                .build();
//
//
//        Coupon coupon3 = Coupon.builder()
//                .amount(80)
//                .category(Category.VACATION)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("A couple's vacation")
//                .description("3 days 2 night in club_hotel")
//                .price(150)
//                .company(c1)
//                .image("https://www.ubagroup.com/57-marina/wp-content/uploads/sites/4/2021/11/Vacation-tips.jpg")
//
//                .build();
//
//
//        Coupon coupon4 = Coupon.builder()
//                .amount(100)
//                .category(Category.ELECTRICITY)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Smart TV")
//                .description("Smart TV with amazing viewing quality")
//                .price(150)
//                .company(c2)
//                .image("https://img.zap.co.il/pics/2/0/2/1/64971202c.gif")
//
//                .build();
//
//
//        Coupon coupon5 = Coupon.builder()
//                .amount(110)
//                .category(Category.FURNITURE)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Living room")
//                .description("A quality and well-designed living room")
//                .price(150)
//                .image("https://www.thespruce.com/thmb/Bhae19SVcbCiBP07x5dR6Ob15nE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/modern-living-room-design-ideas-4126797-hero-a2fd3412abc640bc8108ee6c16bf71ce.jpg")
//                .company(c1)
//
//
//                .build();
//
//
//        Coupon coupon7 = Coupon.builder()
//                .amount(120)
//                .category(Category.SPORT)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("NBA Game")
//                .description("Golden-State vs Boston")
//                .price(150)
//                .image("https://www.si.com/.image/ar_4:3%2Cc_fill%2Ccs_srgb%2Cq_auto:good%2Cw_1200/MTg5ODk4NTg5NDU4MTQ3MDcw/warriors-vs-celtics-site.png")
//                .company(c4)
//                .build();
//
//
//
//
//        Coupon coupon8 = Coupon.builder()
//                .amount(132)
//                .category(Category.ELECTRICITY)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("AirPods")
//                .description("A hearing experience from Apple")
//                .price(170)
//                .image("https://www.gadgety.co.il/wp-content/themes/main/thumbs/2022/09/airpods-pro-2-main.jpg")
//                .company(c4)
//                .build();
//
//
//        Coupon coupon9 = Coupon.builder()
//                .amount(122)
//                .category(Category.FOOD)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Pizza")
//                .description("A pizza tray plus a drink")
//                .price(170)
//                .image("https://www.kipa.co.il/userFiles/2_3645d918ad78b5b00995653912d34b34.jpg")
//                .company(c4)
//                .build();
//
//
//        Coupon coupon10 = Coupon.builder()
//                .amount(99)
//                .category(Category.VACATION)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Family vacation")
//                .description("A whole week in the magical NY")
//                .price(600)
//                .image("https://cdn.travelpulse.com/images/99999999-9999-9999-9999-999999999999/63a056c8-fddb-7732-2acf-fc14766636ca/630x355.jpg")
//                .company(c4)
//                .build();
//
//        Coupon coupon11 = Coupon.builder()
//                .amount(110)
//                .category(Category.FURNITURE)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Bedroom")
//                .description("Designed bedrooms")
//                .price(600)
//                .image("https://media.designcafe.com/wp-content/uploads/2019/12/21000333/indian-bedroom-furniture-designs.jpg")
//                .company(c4)
//                .build();
//
//        Coupon coupon12 = Coupon.builder()
//                .amount(300)
//                .category(Category.SPORT)
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(8)))
//                .title("Treadmill")
//                .description("Designed and comfortable treadmill")
//                .price(600)
//                .image("https://www.lifefitness.be/resource/blob/1611212/9eb3dbb0adcefa80505c3194800bae59/lf-activate-treadmill-v1-data.png")
//                .company(c4)
//                .build();
//
//
//
//
//
//
//        Customer customer1 = Customer.builder()
//                .firstName("Dvir")
//                .lastName("Avivi")
//                .email("dvir@gmail.com")
//                .password("1221")
//                .coupons(Arrays.asList(coupon1, coupon2, coupon3))
//                .build();
//
//        Customer customer2 = Customer.builder()
//                .firstName("Itamat")
//                .lastName("Avivi")
//                .email("ita@gmail.com")
//                .password("1334")
//                .build();
//
//        Customer customer3 = Customer.builder()
//                .firstName("Matan")
//                .lastName("Feldman")
//                .email("matan@gmail.com")
//                .password("1244")
//                .coupons(Arrays.asList(coupon4, coupon2))
//                .build();
//
//
//
//        //  c1.setCoupons(Arrays.asList(coupon1,coupon2));
//
////     couponRepository.saveAll(Arrays.asList(coupon1, coupon2, coupon3, coupon4, coupon5));
//
//
//        companyRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5)).forEach(System.out::println);
//            couponRepository.saveAll(Arrays.asList(coupon1, coupon2, coupon3, coupon4, coupon5,coupon6,coupon7,coupon8,coupon9,coupon10,coupon11,coupon12));
//         customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
//        // System.out.println(companyRepository.findAll());
//
//
//           AdminService adminService = (AdminService) loginManager.login("admin@gmail.com", "admin", ClientType.ADMINISTRATOR);
//         // companyService = (CompanyService) loginManager.login("denya@gmail.com", "1234", ClientType.COMPANY);
//        //System.out.println(companyService.companyDetails());
//            customerService=(CustomerService) loginManager.login("ita@gmail.com","1334",ClientType.CUSTOMER);
//            customerService.purchaseCoupon(customer2.getId(),coupon2.getId());
//        System.out.println(customerService.customerDetails(customer2.getId()));
//
//        //System.out.println(couponRepository.existsCouponByCustomer(1,9));
//
//        //System.out.println(couponRepository.getAllCustomerCoupons(1));
//        //System.out.println(couponRepository.getAllCustomerCouponsByCategory(3,String.valueOf(Category.ELECTRICITY)));
//        // System.out.println(couponRepository.couponCustomerByMaxPrice(1,170));
//
//
//        //customerRepository.saveAll(Arrays.asList(customer1,customer2,customer3));
//
//
//        //  System.out.println(adminService.getOneCompany(1));
//        //   System.out.println(adminService.getAllCompanies());
//
//    }
//}
