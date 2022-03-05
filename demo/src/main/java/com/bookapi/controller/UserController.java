package com.bookapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.dao.UserDao;
import com.bookapi.entities.User;
import com.bookapi.services.UserServices;
import com.bookapi.services.UserServicesImplementation;

@RestController
public class UserController {
	
	
	@Autowired
	UserDao userDao;

	
	@PostMapping("/register")
	public ResponseEntity<HttpStatus> registerUser(@Valid @RequestBody User newUser)
	{
		List<User> users = userDao.findAll();
		for(User aUser : users)
		{
			if((aUser.getEmail()).equals(newUser.getEmail()))
				return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		
		userDao.save(newUser);
			return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> loginUser(@Valid @RequestBody User newUser)
	{
		List<User> users = userDao.findAll();
		for(User aUser : users)
		{
			if((aUser.getEmail()).equals(newUser.getEmail()) && (aUser.getPassword()).equals(newUser.getPassword()))
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);
		
			
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers()
	{  
		
		return userDao.findAll();
	}
	
}

