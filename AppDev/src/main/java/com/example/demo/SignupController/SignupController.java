package com.example.demo.SignupController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.SignupDto.SignupDto;
import com.example.demo.SignupService.SignupService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/signup")
public class SignupController {

    private SignupService signupService;

    // Build Create or Add Department REST API
    @PostMapping
    public ResponseEntity<SignupDto> createSignup(@RequestBody SignupDto signupDto){
        SignupDto signup = signupService.createSignup(signupDto);
        return new ResponseEntity<>(signup, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<SignupDto> getSignupById(@PathVariable("id") Long signupId){
        SignupDto signupDto = signupService.getSignupById(signupId);
        return ResponseEntity.ok(signupDto);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<SignupDto>> getAllSignup(){
        List<SignupDto> signup = signupService.getAllSignup();
        return ResponseEntity.ok(signup);
    }

    // Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<SignupDto> updateSignup(@PathVariable("id") Long signupId,
                                                          @RequestBody SignupDto updatedSignup){
        SignupDto signupDto = signupService.updateSignup(signupId, updatedSignup);
        return ResponseEntity.ok(signupDto);
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignup(@PathVariable("id") Long signupId){
        signupService.deleteSignup(signupId);
        return ResponseEntity.ok("Department deleted successfully!.");
    }

}
