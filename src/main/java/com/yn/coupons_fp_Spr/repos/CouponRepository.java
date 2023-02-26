package com.yn.coupons_fp_Spr.repos;

import com.yn.coupons_fp_Spr.beans.Category;
import com.yn.coupons_fp_Spr.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {




    @Query(value = "select exists( SELECT * FROM coupons_system.coupon where company_id = :company_id and title = :title)",nativeQuery = true)
    int existsTitleCouponBtCompany(@Param("company_id") int company_id, @Param("title") String title);



    @Query(value = "select exists( SELECT * FROM coupons_system.coupon where company_id = :company_id and id = :coupon_id)",nativeQuery = true)
    int existsCouponByCompany(@Param("company_id") int company_id,@Param("coupon_id") int coupon_id);


    @Query(value = "SELECT * FROM coupons_system.coupon where company_id = :company_id",nativeQuery = true)
    List<Coupon> getAllCompanyCoupons(@Param("company_id") int company_id);


    @Query(value = "SELECT * FROM coupons_system.coupon where company_id = :company_id and category = :category",nativeQuery = true)
    List<Coupon>getAllCompanyCouponsByCategory(@Param("company_id")int company_id, @Param("category")String category);


    @Query(value = "SELECT * FROM coupons_system.coupon where company_id = :company_id and price < :maxPrice",nativeQuery = true)
    List<Coupon>getAllCompanyCouponsByMaxPrice(@Param("company_id") int company_id,@Param("maxPrice") double maxPrice);


    @Query(value = "select exists( SELECT * FROM coupons_system.coupons_customers where customer_id = :customer_id and coupon_id = :coupon_id)",nativeQuery = true)
    int existsCouponByCustomer(@Param("customer_id") int customer_id,@Param("coupon_id") int coupon_id);

    @Query(value = "SELECT * FROM coupon as c join coupons_customers as cucu on cucu.coupon_id=c.id where cucu.customer_id = :customer_id",nativeQuery = true)
    List<Coupon> getAllCustomerCoupons(@Param("customer_id") int customer_id);

    @Query(value = "SELECT * FROM coupon as c join coupons_customers as cucu on cucu.coupon_id=c.id where cucu.customer_id = :customer_id and c.category = :category",nativeQuery = true)
    List<Coupon>getAllCustomerCouponsByCategory(@Param("customer_id") int customer_id, @Param("category")String category);

    @Query(value = "SELECT * FROM coupon as c join coupons_customers as cucu on cucu.coupon_id=c.id where cucu.customer_id = :customer_id and c.price < :maxPrice",nativeQuery = true)
    List<Coupon>couponCustomerByMaxPrice(@Param("customer_id")int customer_id,@Param("maxPrice")double maxPrice);

     List<Coupon>  findByCategory(Category category);
}
