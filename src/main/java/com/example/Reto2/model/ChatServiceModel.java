package com.example.Reto2.model;

import java.util.List;

public class ChatServiceModel {

	private Integer id;
	private String name;
	private boolean isPrivate;
	private String createdAt;
	private String updatedAt;

	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private List<User> users;

	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Message> messages;
	private Message message;

	public ChatServiceModel() {
	}

	public ChatServiceModel(Integer id, String name, boolean isPrivate, String createdAt, String updatedAt,
			List<User> users, List<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.users = users;
		this.messages = messages;
	}
	

	public ChatServiceModel(Integer id, String name, boolean isPrivate, Message message) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.message = message;
	}

	public ChatServiceModel(String name, boolean isPrivate) {
		super();

		this.name = name;
		this.isPrivate = isPrivate;
	}
	

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
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
		return "GroupServiceModel [id=" + id + ", name=" + name + ", isPrivate=" + isPrivate + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", users=" + users + ", messages=" + messages + "]";
	}
}
