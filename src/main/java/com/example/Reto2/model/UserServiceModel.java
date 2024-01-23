package com.example.Reto2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserServiceModel {
	
	private Integer id;
	private String email;
	private String password;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Role> roles;

	public UserServiceModel() {}
	public UserServiceModel(Integer id, String email, String password, List<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public UserServiceModel(Integer id, String email, List<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserServiceModel [id=" + id + ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}

}
