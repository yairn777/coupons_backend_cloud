package com.yn.coupons_fp_Spr.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private int id;
    private String email;
    private String name;
//    private ClientType type;
    private LocalDateTime localDateTime;
}
