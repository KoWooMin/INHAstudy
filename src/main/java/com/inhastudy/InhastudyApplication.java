package com.inhastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class InhastudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InhastudyApplication.class, args);
	}

}
