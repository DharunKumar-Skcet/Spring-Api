package com.example.demo.SignupService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.SignupDto.SignupDto;

@Service

public interface SignupService {
    SignupDto createSignup(SignupDto signupDto);

    SignupDto getSignupById(Long signupId);

    List<SignupDto> getAllSignup();

    SignupDto updateSignup(Long signupId, SignupDto updatedSignup);

    void deleteSignup(Long signupId);
}

