package com.proyecto1.ecommerce.domain;

import java.util.List;

public class Role {
	private int roleId;
	private String name;
	List<Role> roles;

	public Role() {
		super();
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setName(String name) {
		this.name = name;
	}

}
