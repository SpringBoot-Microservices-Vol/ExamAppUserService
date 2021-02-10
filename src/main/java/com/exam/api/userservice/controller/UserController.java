package com.exam.api.userservice.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exam.api.userservice.dto.UserDto;
import com.exam.api.userservice.model.CreateUserResponse;
import com.exam.api.userservice.model.CreateUserRequest;
import com.exam.api.userservice.service.UserService;

@RestController
public class UserController {

	private UserService userService;
	private ModelMapper modelMapper;
	private Environment env;

	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper, Environment env) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.env = env;
	}

	@GetMapping("/check")
	public String getCurrentToken() {
		return "Working on port" + env.getProperty("local.server.port") + ", with token = "
				+ env.getProperty("token.secret");
	}

	@PostMapping("/users")
	public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

		UserDto userDto = modelMapper.map(request, UserDto.class);
		CreateUserResponse resReponse = modelMapper.map(userService.createUser(userDto), CreateUserResponse.class);
		return new ResponseEntity<>(resReponse, HttpStatus.CREATED);
	}
}
