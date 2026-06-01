package com.mohit.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(
	        HttpSecurity http
	) throws Exception {

	    http

	    
	        .authorizeHttpRequests(auth -> auth

	            .requestMatchers(
	                    "/admin/**"
	            ).authenticated()

	            .requestMatchers(
	                    "/",
	                    "/login",
	                    "/about",
	                    "/projects",
	                    "/skills",
	                    "/contact",
	                    
	                    "/contact/send",
	                    "/css/**",
	                    "/js/**",
	                    "/images/**"
	            ).permitAll()

	            .anyRequest().permitAll()
	        )

	        .formLogin(form -> form

	        	    .loginPage("/login")

	        	    .defaultSuccessUrl(
	        	            "/admin/messages",
	        	            true
	        	    )

	        	    .permitAll()
	        	)
	        .logout(logout -> logout
	                .permitAll()
	        );

	    return http.build();
	}
}