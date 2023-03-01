package com.openmarkethub.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openmarkethub.dtos.UserDTO;
import com.openmarkethub.services.UserService;
import com.openmarkethub.utilities.ApiResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	//POST- create user
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO createdUserDTO =  this.userService.createUser(userDTO);
		return new ResponseEntity<UserDTO>(createdUserDTO, HttpStatus.CREATED);
	}
	
	
	//PUT - update user
	@PutMapping("{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("userId") Integer userId){
		UserDTO updatedUser =  this.userService.updateUser(userDTO, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);
		return  ResponseEntity.ok(new ApiResponse("User Deleted Sucessfully", true));
	}
	
	
	//GET - get user
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId){
		return ResponseEntity.ok(this.userService.getUserByID(userId));
	}
	
	//get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>>  getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUser());
		
	}




}
