package com.exam.api.userservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.exam.api.userservice.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto userDetails);
}
