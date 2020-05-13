package com.exam.api.userservice.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.api.userservice.model.CreateUserRequest;

@RestController
@RequestMapping("/users")
public class UserController {

	@PostMapping
	public String createUser(@Valid @RequestBody CreateUserRequest request) {
		return "Create user";
	}
}
