package com.inhastudy.domain;

import com.inhastudy.dto.SignUpRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class SignUp {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = true)
    private String major;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private Integer grade;

    @Column(nullable = true)
    private String sex;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String checkLogin;

    @Column(nullable = true)
    private String ssn;

    public SignUp(String id, String major, String username, String password, Integer grade, String sex, String phoneNumber, String email, String checkLogin, String ssn) {
        this.id = id;
        this.major = major;
        this.username = username;
        this.password = password;
        this.grade = grade;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.checkLogin = checkLogin;
        this.ssn = ssn;
    }

    public SignUp(SignUpRequestDto requestDto) {
        this.id = requestDto.getId();
        this.major = requestDto.getMajor();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.grade = requestDto.getGrade();
        this.sex = requestDto.getSex();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.email = requestDto.getEmail();
        this.checkLogin = requestDto.getCheckLogin();
        this.ssn = requestDto.getSsn();
    }

    public void update(SignUpRequestDto signupRequestDto) {
        this.id = signupRequestDto.getId();
        this.major = signupRequestDto.getMajor();
        this.username = signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.grade = signupRequestDto.getGrade();
        this.sex = signupRequestDto.getSex();
        this.phoneNumber = signupRequestDto.getPhoneNumber();
        this.email = signupRequestDto.getEmail();
        this.checkLogin = signupRequestDto.getCheckLogin();
        this.ssn = signupRequestDto.getSsn();
    }

    public void updateCheckLogin(String checkLogin){
        this.checkLogin = checkLogin;
    }
}
