package com.puneet.hotelbookingsystem.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HotelSecurityConfig {

	// This method get user details from the database 
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		// Takes data from the default tables users and authorities
		//	return new JdbcUserDetailsManager(dataSource);
		
		// Create Jdbc user details manager variable object
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		// Define the query to get the user from the custom table
		jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?");
		
		// Define the query to get the role from the custom table
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?");		
		
		return jdbcUserDetailsManager;
	}
	
	// This bean method filters and authorizes which role can access which resource to perform which action
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(configurer -> 
			configurer
			.requestMatchers(HttpMethod.GET, "/api/hotels/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
			.requestMatchers(HttpMethod.POST, "/api/hotels/**").hasAnyRole("MANAGER", "ADMIN")
			.requestMatchers(HttpMethod.PUT, "/api/hotels/**").hasAnyRole("MANAGER", "ADMIN")
			.requestMatchers(HttpMethod.DELETE, "/api/hotels/**").hasRole("ADMIN")
		);
		
		// Enable basic security
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		// Disable cross site request forgery because it is generally not required for stateless REST APIs that use (GET, POST, PUT, DELETE)
		httpSecurity.csrf(csrf -> csrf.disable());
		
		return httpSecurity.build();
	}
}
