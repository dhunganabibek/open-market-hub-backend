package com.openmarkethub.serviceImpl;

import com.openmarkethub.dtos.UserDTO;
import com.openmarkethub.entities.User;
import com.openmarkethub.exceptions.ResourceNotFoundException;
import com.openmarkethub.repositories.UserRepository;
import com.openmarkethub.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.modelMapper.map(userDTO, User.class);
		User savedUser = this.userRepository.save(user);
		return this.modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepository.delete(user);
		
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		User updatedUser = this.userRepository.save(user);
		return this.modelMapper.map(updatedUser, UserDTO.class);
	}

	@Override
	public UserDTO getUserByID(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));
		return this.modelMapper.map(user, UserDTO.class);
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users = this.userRepository.findAll();
		List<UserDTO> userDTOs = users.stream().map(user -> this.modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
		return userDTOs;
	}
 
}
