package com.example.Reto2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ChatPostRequest {

	@NotNull(message = "El nombre no puede ser nulo")
	@NotEmpty(message = "El nombre no puede ser vacio")
	@NotBlank(message = "El nombre no puede ser blanco")
	private String name;
	private boolean isPrivate;
	private Integer creatorId;

	public ChatPostRequest() {
	}
	public ChatPostRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String name,
			boolean isPrivate) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
	}
	public ChatPostRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String name,
			boolean isPrivate, Integer creatorId) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
		this.creatorId = creatorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	@Override
	public String toString() {
		return "ChatPostRequest [name=" + name + ", isPrivate=" + isPrivate + ", creatorId=" + creatorId + "]";
	}


}
