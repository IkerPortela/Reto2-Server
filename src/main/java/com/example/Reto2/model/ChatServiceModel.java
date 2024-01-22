package com.example.Reto2.model;

import java.util.List;

public class ChatServiceModel {

	private Integer id;
	private String name;
	private boolean is_private;
	private String createdAt;
	private String updatedAt;

	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private List<User> users;

	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Message> messages;

	public ChatServiceModel() {
	}

	public ChatServiceModel(Integer id, String name, boolean isPrivate, String createdAt, String updatedAt,
			List<User> users, List<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.is_private = isPrivate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.users = users;
		this.messages = messages;
	}

	public ChatServiceModel(String name, boolean isPrivate) {
		super();

		this.name = name;
		this.is_private = isPrivate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "GroupServiceModel [id=" + id + ", name=" + name + ", isPrivate=" + is_private + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", users=" + users + ", messages=" + messages + "]";
	}
}
