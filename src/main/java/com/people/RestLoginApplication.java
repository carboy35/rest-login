package com.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableAuthorizationServer
public class RestLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLoginApplication.class, args);
	}

}