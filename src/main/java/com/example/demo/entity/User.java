package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
	@Id
	private String UserName;
	private String UserFirstName;
	private String UserLastName;
	private String UserPassword;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE",
	joinColumns = {
			@JoinColumn(name="USER_ID")
			},
		inverseJoinColumns = {
				@JoinColumn(name ="ROLE_ID")
		}
	)
	private Set<Role> role;

	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getUserFirstName() {
		return UserFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		UserFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return UserLastName;
	}
	
	public void setUserLastName(String userLastName) {
		UserLastName = userLastName;
	}
	
	public String getUserPassword() {
		return UserPassword;
	}
	
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	
	public Set<Role> getRole() {
		return role;
	}
	
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
}
