package com.example.HealthClinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HealthClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthClinicApplication.class, args);
	}

}
