package com.example.demo.SignupService.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.SignupDto.SignupDto;
import com.example.demo.SignupEntity.SignupEntity;
import com.example.demo.SignupException.SignupException;
import com.example.demo.SignupMapper.SignupMapper;
import com.example.demo.SignupRepository.SignupRepository;
import com.example.demo.SignupService.SignupService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SignupServiceImpl implements SignupService {

    private SignupRepository signupRepository;

    @Override
    public SignupDto createSignup(SignupDto signupDto) {
        SignupEntity signup = SignupMapper.mapToSignup(signupDto);
        SignupEntity savedsignup = signupRepository.save(signup);
        return SignupMapper.mapToSignupDto(savedsignup);
    }

    @Override
    public SignupDto getSignupById(Long signupId) {
        SignupEntity signup = signupRepository.findById(signupId).orElseThrow(
                () -> new SignupException("Department is not exists with a given id: " + signupId)
        );
        return SignupMapper.mapToSignupDto(signup);
    }

    @Override
    public List<SignupDto> getAllSignup() {
        List<SignupEntity> signup = signupRepository.findAll();
        return signup.stream().map((sign) -> SignupMapper.mapToSignupDto(sign))
                .collect(Collectors.toList());
    }

    @Override
    public SignupDto updateSignup(Long signupId, SignupDto updatedSignup) {

        SignupEntity signup = signupRepository.findById(signupId).orElseThrow(
                () -> new SignupException("Department is not exists with a given id:"+ signupId)
        );

        signup.setName(updatedSignup.getName());
        signup.setEmail(updatedSignup.getEmail());
        signup.setPassword(updatedSignup.getPassword());

        SignupEntity savedSignup = signupRepository.save(signup);

        return SignupMapper.mapToSignupDto(savedSignup);
    }

    @Override
    public void deleteSignup(Long signupId) {
        SignupEntity signup = signupRepository.findById(signupId).orElseThrow(
                () -> new SignupException("Department is not exists with a given id: " + signupId)
        );

        signupRepository.deleteById(signupId);
    }
}
