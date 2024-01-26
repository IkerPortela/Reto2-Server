package com.example.Reto2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ChatServiceModel {

	private Integer id;
	private String name;
	private boolean isPrivate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User creator;
	private Integer creatorId;
	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private List<User> users;

	// @JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Message> messages;
	private Message message;

	public ChatServiceModel() {
	}

	public ChatServiceModel(String name, boolean isPrivate, User creator, Integer creatorId) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
		this.creator = creator;
		this.creatorId = creatorId;
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

	public ChatServiceModel(Integer id, String name, boolean isPrivate,
			User creator, Integer creatorId, List<User> users, List<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.creator = creator;
		this.creatorId = creatorId;
		this.users = users;
		this.messages = messages;
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
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
		return "ChatServiceModel [id=" + id + ", name=" + name + ", isPrivate=" + isPrivate + ", createdAt="  + ", creator=" + creator + ", creatorId=" + creatorId + ", users=" + users
				+ ", messages=" + messages + "]";
	}
}
