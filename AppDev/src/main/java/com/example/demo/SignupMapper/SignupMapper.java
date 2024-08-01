package com.example.demo.SignupMapper;

import com.example.demo.SignupDto.SignupDto;
import com.example.demo.SignupEntity.SignupEntity;


public class SignupMapper {

    // convert department jpa entity into department dto
    public static SignupDto mapToSignupDto(SignupEntity signup){
        return new SignupDto(
                signup.getId(),
                signup.getName(),
                signup.getEmail(),
                signup.getPassword()
        );
    }

    // convert department dto into department jpa entity
    public static SignupEntity mapToSignup(SignupDto signupDto){
        return new SignupEntity(
        		signupDto.getId(),
        		signupDto.getName(),
        		signupDto.getEmail(),
        		signupDto.getPassword()
                
        );
    }
}
