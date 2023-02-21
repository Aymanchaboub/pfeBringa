package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostConstruct
	public void initRolesAndUser() {
		userService.initRoleAndUser();
		
	}
	@PostMapping({"/CreateUser"})
	public User RegisterNewUser(@RequestBody User user)
	{
		return userService.RegisterNewUser(user);
	}
	@GetMapping({"/forAdmin"})
	public String forAdmin()
	{
		return "this Url is for Admin";
	}
	@GetMapping({"/forUser"})
	public String forUser()
	{
		return "this Url is for users";
	}
	
}
