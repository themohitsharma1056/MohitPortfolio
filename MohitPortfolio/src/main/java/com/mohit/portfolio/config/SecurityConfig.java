package com.mohit.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;
	
    @Bean
		public UserDetailsService users() {
	

		    UserDetails admin = User
		            .withUsername(adminUsername)
		            .password("{noop}" + adminPassword)
		            .roles("ADMIN")
		            .build();

		    return new InMemoryUserDetailsManager(admin);
		}
	
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