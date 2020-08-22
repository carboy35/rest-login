//package com.people.controllers;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.nimbusds.jwt.JWT;
//@RequestMapping("/user")
//public class LoginController {
//	 @Autowired
//	    private JwtTokenStore tokenStore;
//
//		@GetMapping("/validateUser")
//		public Principal user(Principal user) {
//			return user;
//		}
//		
//}
