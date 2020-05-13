package com.exam.api.userservice.model;

import java.io.Serializable;

public class CreateUserReponse implements Serializable {

	private static final long serialVersionUID = 34885533402688975L;

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
