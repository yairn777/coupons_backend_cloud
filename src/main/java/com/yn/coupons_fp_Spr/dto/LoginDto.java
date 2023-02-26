package com.yn.coupons_fp_Spr.dto;


import com.yn.coupons_fp_Spr.security.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String email;

    private  String password;

    private ClientType clientType;



//    public String getClientType(String clientType) {
//        return clientType ;
//    }
}
