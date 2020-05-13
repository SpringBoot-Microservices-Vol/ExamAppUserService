package com.exam.api.userservice.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 6800775957712077915L;

	private String username;
	private String password;
	private String email;
	private String userId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
