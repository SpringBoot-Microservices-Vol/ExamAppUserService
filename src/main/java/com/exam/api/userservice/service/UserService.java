package com.exam.api.userservice.service;

import com.exam.api.userservice.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDetails);
}
