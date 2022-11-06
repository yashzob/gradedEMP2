package com.EmpMgmt2.EmpMgmt.security;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema()
		.withUser(User.withUsername("yash").password(getPasswordEncoder().encode("welcome")).roles("Admin"))
		.withUser(User.withUsername("angi").password(getPasswordEncoder().encode("welcome")).roles("User"));
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/api/employee/**")
				.hasAnyRole("User","Admin")
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST,"/api/employee/**")
				.hasRole("Admin")
			.antMatchers("/h2-console/**")
				.hasRole("Admin")
			.antMatchers(HttpMethod.PUT,"/api/employee/**")
				.hasRole("Admin")
			.antMatchers(HttpMethod.DELETE,"/api/employee/**")
				.hasRole("Admin")
			.anyRequest()
				.authenticated()
			.and()
				.formLogin()
			.and()
				.httpBasic();
//			.and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
	
	
}
}