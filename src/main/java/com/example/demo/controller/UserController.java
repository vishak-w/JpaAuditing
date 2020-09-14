package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.userEntity.User;
import com.example.demo.userRepository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository  userRepository;
	
	@GetMapping(value="/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	@GetMapping(value="/users/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable(value="id") Long userId)
	{
		Optional<User> user=userRepository.findById(userId);
				
		return ResponseEntity.ok().body(user);
	}
	@PostMapping(value="users")
	public User createUser(@Validated @RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	

}
