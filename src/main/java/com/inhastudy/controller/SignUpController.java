package com.inhastudy.controller;

import com.inhastudy.domain.SignUp;
import com.inhastudy.repository.SignUpRepository;
import com.inhastudy.dto.SignUpRequestDto;
import com.inhastudy.service.SignUpService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SignUpController {
    private final SignUpRepository signupRepository;
    private final SignUpService signupService;

    @GetMapping("/signup")
    public String signupPage(){
        return "signup.html";
    }

    @PostMapping("/api/signup")
    public SignUp SignUp(@RequestBody SignUpRequestDto signupRequestDto) {
        SignUp signup = new SignUp(signupRequestDto);

        return signupRepository.save(signup);
    }

    @GetMapping("/api/signup")
    public List<SignUp> getSignUps() {
        return signupRepository.findAll();
    }

    @DeleteMapping("/api/signup/{id}")
    public String deleteSignUp(@PathVariable String id) {
        signupRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/signup/{id}")
    public String updateSignUp(@PathVariable String id, @RequestBody SignUpRequestDto signupRequestDto) {
        signupService.update(id, signupRequestDto);
        return id;
    }

    @GetMapping("/api/login/{inputId}")
    public String getOneSignUp(@PathVariable String inputId){
        return signupRepository.findSignUpById(inputId).getPassword();
    }

    @PutMapping("/api/acceptlogin/{inputId}")
    public void acceptLogin(@PathVariable String inputId){
        SignUp signUp = signupRepository.findSignUpById(inputId);
        signupService.updateCheckLogin(signUp, "Y");
    }

    @GetMapping("/api/IdOverlapCheck/{inputId}")
    public Boolean idOverlapCheck(@PathVariable String inputId){
        boolean IdOverlap;
        SignUp signUp = signupRepository.findSignUpById(inputId);
        if(signUp == null) {
            IdOverlap = false;
        } else {
            IdOverlap = true;
        }
        return IdOverlap;
    }

    @GetMapping("/api/deliverId/{inputId}")
    public String deliverId(@PathVariable String inputId){

        return "/home";
    }
}
