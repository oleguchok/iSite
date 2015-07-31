package com.oguchok.isite.persistence.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.oguchok.isite.validation.PasswordMatches;
import com.oguchok.isite.validation.ValidEmail;

@PasswordMatches
public class UserDTO {

	@NotNull
	@NotEmpty
	private String username;
	
	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
	private String mathcingPassword;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMathcingPassword() {
		return mathcingPassword;
	}
	public void setMathcingPassword(String mathcingPassword) {
		this.mathcingPassword = mathcingPassword;
	}
}
