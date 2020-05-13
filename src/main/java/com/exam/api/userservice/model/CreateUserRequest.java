package com.exam.api.userservice.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequest implements Serializable {

	private static final long serialVersionUID = 4406978961703391359L;

	@NotNull(message = "Username can not be null")
	@Size(min = 6, message = "Username must not be less then six charactes")
	private String username;
	@NotNull(message = "Password can not be null")
	@Size(min = 6, message = "Password must not be less then six charactes")
	private String password;
	@NotNull(message = "Email can not be null")
	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
