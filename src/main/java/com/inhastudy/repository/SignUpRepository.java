package com.inhastudy.repository;

import com.inhastudy.domain.SignUp;
import com.inhastudy.dto.SignUpRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SignUpRepository extends JpaRepository<SignUp, String>{
    SignUp findSignUpById(String id);
}
