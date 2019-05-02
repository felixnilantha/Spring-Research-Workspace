package com.spring.research.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();
		//@formatter:off
		auth.inMemoryAuthentication()
					.withUser(users.username("john")
								   .password("test123")
								   .roles("EMPLOYEE"))
					
					.withUser(users.username("mary")
								   .password("test123")
								   .roles("EMPLOYEE"))
					
					.withUser(users.username("peter")
								   .password("test123")
								   .roles("EMPLOYEE"));
		
		//@formatter:on
	}

}
