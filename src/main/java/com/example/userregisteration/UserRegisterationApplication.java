package com.example.userregisteration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class UserRegisterationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegisterationApplication.class, args);
	}

}
