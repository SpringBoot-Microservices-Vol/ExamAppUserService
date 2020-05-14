package com.exam.api.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.exam.api.userservice.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);
}
