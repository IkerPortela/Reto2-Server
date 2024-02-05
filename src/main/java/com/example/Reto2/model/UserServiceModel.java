package com.example.Reto2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserServiceModel {
	
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String address;
	private int phone;
	private String dni;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<RoleServiceModel> roles;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ChatServiceModel> chats;

	public UserServiceModel() {}
	public UserServiceModel(Integer id, String email, String password, List<RoleServiceModel> roles, List<ChatServiceModel> chats) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.chats = chats;
	}
	
	public UserServiceModel(Integer id, String email, List<RoleServiceModel> roles) {
		super();
		this.id = id;
		this.email = email;
		this.roles = roles;
	}
	
	public UserServiceModel(Integer id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public UserServiceModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UserServiceModel(Integer id, String email, String password, String name, String surname, String address,
			int phone, String dni, List<RoleServiceModel> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.dni = dni;
		this.roles = roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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

	public List<RoleServiceModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleServiceModel> roles) {
		this.roles = roles;
	}
	
	public List<ChatServiceModel> getChats() {
		return chats;
	}
	
	public void setChats(List<ChatServiceModel> chats) {
		this.chats = chats;
	}
	@Override
	public String toString() {
		return "UserServiceModel [id=" + id + ", email=" + email + ", password=" + password + ", roles=" + roles + ", chats=" + chats + "]";
	}

}
