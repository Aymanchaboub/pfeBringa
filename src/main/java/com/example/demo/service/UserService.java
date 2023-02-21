package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

@Service
public class UserService {
	@Autowired 
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	public User RegisterNewUser(User user)
	{
		return userDao.save(user);
	}
	public void initRoleAndUser() 
	{
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role for Users");
		roleDao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("User Role for Defaults");
		roleDao.save(userRole);
		
		
		User AdminUser=new User();
		AdminUser.setUserName("admin@gmail.com");
		AdminUser.setUserFirstName("ayman");
		AdminUser.setUserLastName("chabchoub");
		AdminUser.setUserPassword("123");
		Set<Role> adminRoles=new HashSet<>();
		AdminUser.setRole(adminRoles);
		adminRoles.add(adminRole);
		userDao.save(AdminUser);
		
		
		User user=new User();
		user.setUserName("user@gmail.com");
		AdminUser.setUserFirstName("khalil");
		AdminUser.setUserLastName("Ben Atitallah");
		AdminUser.setUserPassword("123");
		Set<Role> userRoles=new HashSet<>();
		user.setRole(userRoles);
		userRoles.add(userRole);
		userDao.save(user);
	}
}
