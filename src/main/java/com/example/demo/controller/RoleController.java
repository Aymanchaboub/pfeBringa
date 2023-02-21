package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {
	
	private RoleService roleService;
	@PostMapping({"/CreateRole"})
	public Role CreateNewRole(@RequestBody Role role) {
		return roleService.CreateNewRole(role);
	}
}
