package com.gotrybe.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.gotrybe.dto.UserDto;
import com.gotrybe.entity.User;

public interface UserServiceInterface {

	
	User getUserByName(String username);
	
	List<User> allUser();
	
	User getUserById(UUID id);
	
	UserDto createUser(UserDto userDto);
	
	void deleteUserById(UUID id);
	
	UserDto updateUserById(UUID id, UserDto userDto);
	
	UserDto patchUserById(UUID id, UserDto userDto);
	
	Page<User> paginationUser(int page, int size);
}
