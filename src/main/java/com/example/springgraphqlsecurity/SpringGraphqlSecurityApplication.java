package com.example.springgraphqlsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;

@EnableReactiveMethodSecurity
@SpringBootApplication
public class SpringGraphqlSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlSecurityApplication.class, args);
	}

}
