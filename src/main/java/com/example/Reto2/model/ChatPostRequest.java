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
	private boolean isPrivate;
	private String createdAt;
	private String updatedAt;
    private List<User> users;
    private List<Message> messages;
    
    public ChatPostRequest() {}
	public ChatPostRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String name,
			boolean isPrivate, String createdAt, String updatedAt, List<User> users,
			List<Message> messages) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.users = users;
		this.messages = messages;
	}
	
	public ChatPostRequest(
			@NotNull(message = "El nombre no puede ser nulo") @NotEmpty(message = "El nombre no puede ser vacio") @NotBlank(message = "El nombre no puede ser blanco") String name,
			boolean isPrivate) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@Override
	public String toString() {
		return "GroupPostRequest [name=" + name + ", isPrivate=" + isPrivate + ", createdAt=" + createdAt 
				+ ", updateAt=" + updatedAt + ", users=" + users + ", messages=" + messages
				+ "]";
	}
}
