package com.proyecto1.ecommerce.domain;
import java.util.LinkedList;
import java.util.List;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private List<Role> roles;
	private int jeison;
	

	public User() {
		roles=new LinkedList<Role>();
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}