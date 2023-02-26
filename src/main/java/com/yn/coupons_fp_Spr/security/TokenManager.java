package com.yn.coupons_fp_Spr.security;

import com.yn.coupons_fp_Spr.dto.LoginResDto;
import com.yn.coupons_fp_Spr.exceptions.CouponsException;
import com.yn.coupons_fp_Spr.exceptions.ErrMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenManager {

    private final Map<UUID,UserInfo>map=new HashMap<>();



    public LoginResDto add(int id, String email, String password,ClientType clientType){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setEmail(email);
//        userInfo.setType(clientType);
        userInfo.setLocalDateTime(LocalDateTime.now());
        UUID token=UUID.randomUUID();

        map.put(token,userInfo);
        System.out.println(map);

        return new LoginResDto(token,email,clientType);
    }



    public int getUInfoId(UUID token) throws CouponsException {
        UserInfo userInfo=map.get(token);
        if(userInfo==null){
            throw new CouponsException(ErrMsg.INVALID_TOKEN);
        }

        return userInfo.getId();
    }



}

