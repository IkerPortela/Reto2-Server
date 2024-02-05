package com.example.Reto2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserPutRequest {

	@NotNull(message = "El nombre no puede ser nulo")
	@NotEmpty(message = "El nombre no puede ser vacio")
	@NotBlank(message = "El nombre no puede ser blanco")
	private String email;
	private String password;

	public UserPutRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String email) {
		super();
		this.email = email;
	}

	public UserPutRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String email,
			String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "UserPutRequest [email=" + email + ", password" + password + "]";
	}
	
}
