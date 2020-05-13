package com.exam.api.userservice.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.api.userservice.dto.UserDto;
import com.exam.api.userservice.entity.UserEntity;
import com.exam.api.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDto.class);
	}
}
