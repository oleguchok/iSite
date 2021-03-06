package com.oguchok.isite.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages = {"com.oguchok.isite.security"})
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	DataSource dataSource;
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	    http
	    	.authorizeRequests()
	    		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
	    		.and()
	    	.formLogin()
	    		.loginPage("/login")
	    		.defaultSuccessUrl("/")
	    		.failureUrl("/login?error")
	    		.usernameParameter("username")
	    		.passwordParameter("password")
	    		.and()
	    	.rememberMe()
	    		.tokenValiditySeconds(186400)
	    		.and()
	    	.logout()
	    		.logoutSuccessUrl("/")
	    		.deleteCookies("JSESSIONID")
	    		.and()
	    	.csrf()
	    		.and().
	    	exceptionHandling().accessDeniedPage("/403");
	}

	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
 
}