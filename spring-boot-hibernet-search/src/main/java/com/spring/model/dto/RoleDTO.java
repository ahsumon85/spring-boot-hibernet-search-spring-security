package com.spring.model.dto;

import com.spring.model.entity.User;

public class RoleDTO {

	  private int id;
	
	  private String role;
	
	  private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	  
}
