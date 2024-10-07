package com.gotrybe.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gotrybe.dto.UserDto;
import com.gotrybe.entity.User;
import com.gotrybe.repository.UserRepository;
import com.gotrybe.service.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public User getUserByName(String username) {
 		return repository.findByUsername(username).orElseThrow();
	}

	@Override
	public List<User> allUser() {
 		return repository.findAll();
	}

	@Override
	public User getUserById(UUID id) {
 		return repository.findById(id).orElseThrow();
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		repository.save(user);
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public void deleteUserById(UUID id) {
		repository.deleteById(id);		
	}

	@Override
	public UserDto updateUserById(UUID id, UserDto userDto) {
 		User user = mapper.map(userDto, User.class);
		
		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		
		repository.saveAndFlush(user);
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public UserDto patchUserById(UUID id, UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		
 		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());		
		
		repository.flush();
		UserDto dto = mapper.map(user, UserDto.class);
		return dto;
		 
	}

	@Override
	public Page<User> paginationUser(int page, int size) {
 
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
	
}
