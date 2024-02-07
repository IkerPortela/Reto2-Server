package com.example.Reto2.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UpdateResponse {
	@NotNull @Email @Length(min = 5, max = 50)
	private String email;
	@NotNull @Length(min = 5, max = 20)
	private String password;
	@NotNull @Length(min = 5, max = 100)
	private String name;
	@NotNull @Length(min = 5, max = 100)
	private String surname;
	@NotNull @Length(min = 5, max = 20)
	private Integer phone;
	@NotNull @Length(min = 5, max = 20)
	private String dni;
	@NotNull @Length(min = 5, max = 100)
	private String address;
	
	private List<RoleServiceModel> roles;
	
	public UpdateResponse() {
		super();
	}
	
	public UpdateResponse(@NotNull @Email @Length(min = 5, max = 50) String email,
			@NotNull @Length(min = 5, max = 20) String password, @NotNull @Length(min = 5, max = 100) String name,
			@NotNull @Length(min = 5, max = 100) String surname, @NotNull @Length(min = 5, max = 20) Integer phone,
			@NotNull @Length(min = 5, max = 20) String dni, @NotNull @Length(min = 5, max = 100) String address,
			List<RoleServiceModel> roles) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.dni = dni;
		this.address = address;
		this.roles = roles;
	}

	public UpdateResponse(@NotNull @Email @Length(min = 5, max = 50) String email,
			@NotNull @Length(min = 5, max = 20) String password, @NotNull @Length(min = 5, max = 100) String name,
			@NotNull @Length(min = 5, max = 100) String surname, @NotNull @Length(min = 5, max = 20) Integer phone,
			@NotNull @Length(min = 5, max = 20) String dni, @NotNull @Length(min = 5, max = 100) String address) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.dni = dni;
		this.address = address;
	}
	
	public List<RoleServiceModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleServiceModel> roles) {
		this.roles = roles;
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
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
