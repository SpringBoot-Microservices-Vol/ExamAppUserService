package com.exam.api.userservice.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.api.userservice.dto.UserDto;
import com.exam.api.userservice.model.CreateUserResponse;
import com.exam.api.userservice.model.CreateUserRequest;
import com.exam.api.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private ModelMapper modelMapper;

	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

		UserDto userDto = modelMapper.map(request, UserDto.class);
		CreateUserResponse resReponse = modelMapper.map(userService.createUser(userDto), CreateUserResponse.class);
		return new ResponseEntity<>(resReponse, HttpStatus.CREATED);
	}
}
