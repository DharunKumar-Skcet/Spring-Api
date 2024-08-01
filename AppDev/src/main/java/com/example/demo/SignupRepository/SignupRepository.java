package com.example.demo.SignupRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.SignupEntity.SignupEntity;


public interface SignupRepository extends JpaRepository<SignupEntity, Long> {
}
