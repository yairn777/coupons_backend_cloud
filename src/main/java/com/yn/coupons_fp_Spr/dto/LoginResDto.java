package com.yn.coupons_fp_Spr.dto;

import com.yn.coupons_fp_Spr.security.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResDto {
    private UUID token;
    private String email;
    private ClientType clientType;

}
