package com.yn.coupons_fp_Spr.repos;

import com.yn.coupons_fp_Spr.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email,String password);

    @Query(value = "SELECT id FROM coupons_system.customer where email = :email",nativeQuery = true)
    int customer_id(@Param("email") String email);


}
