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
	
	

	public UserServiceModel(Integer id, String email, String password, String name, String surname, String address,
			int phone, String dni, List<Role> roles) {
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
