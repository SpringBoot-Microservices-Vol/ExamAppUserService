package com.exam.api.userservice.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.api.userservice.dto.UserDto;
import com.exam.api.userservice.entity.UserEntity;
import com.exam.api.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository,
			ModelMapper modelMapper) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDto.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username);

		if (userEntity == null)
			throw new UsernameNotFoundException(username);

		return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());
	}
}
