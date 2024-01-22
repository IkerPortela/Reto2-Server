package com.example.Reto2.model;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ChatPostRequest {

	@NotNull(message = "El nombre no puede ser nulo")
	@NotEmpty(message = "El nombre no puede ser vacio")
	@NotBlank(message = "El nombre no puede ser blanco")
	private String name;
	private boolean is_private;

	// private List<User> users;
	// private List<Message> messages;

	public ChatPostRequest() {
	}

	public ChatPostRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String name,
			boolean isPrivate) {
		super();
		this.name = name;
		this.is_private = isPrivate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrivate() {
		return is_private;
	}

	public void setPrivate(boolean isPrivate) {
		this.is_private = isPrivate;
	}

	@Override
	public String toString() {
		return "GroupPostRequest [name=" + name + ", isPrivate=" + is_private + "]";
	}
}
