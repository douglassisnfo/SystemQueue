package com.douglaz.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegisterClientApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RegisterClientApplication.class, args);
	}

}
