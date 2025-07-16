package com.example.UberEntityService.models;

import java.util.Random;

import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OTP extends BaseModel{

    private String code;

    private String sentToNumber;

    public static OTP generateOTP(String phoneNumber){
        Random random=new Random();

        Integer code=random.nextInt(9000)+1000;

        return OTP.builder().code(code.toString()).sentToNumber(phoneNumber).build();

    }


}
