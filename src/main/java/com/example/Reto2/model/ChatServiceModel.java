package com.example.Reto2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ChatServiceModel {

	private Integer id;
	private String name;
	private boolean isPrivate;

	@JsonInclude(JsonInclude.Include.NON_NULL)

	private UserServiceModel creator;
	private Integer creatorId;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<UserServiceModel> users;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<MessageServiceModel> messages;
	private MessageServiceModel message;

	public ChatServiceModel() {
	}

	public ChatServiceModel(Integer id) {
		super();
		this.id = id;
	}

	public ChatServiceModel(Integer id, String name, boolean isPrivate, Integer creatorId) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.creatorId = creatorId;
	}

	public ChatServiceModel(String name, boolean isPrivate, UserServiceModel creator, Integer creatorId) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
		this.creator = creator;
		this.creatorId = creatorId;
	}

	public ChatServiceModel(Integer id, String name, boolean isPrivate) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;

	}

	public ChatServiceModel(Integer id, String name, boolean isPrivate, MessageServiceModel message) {
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

	public ChatServiceModel(Integer id, String name, boolean isPrivate, UserServiceModel creator, Integer creatorId,
			List<UserServiceModel> users, List<MessageServiceModel> messages) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.creator = creator;
		this.creatorId = creatorId;
		this.users = users;
		this.messages = messages;
	}

	public MessageServiceModel getMessage() {
		return message;
	}

	public void setMessage(MessageServiceModel message) {
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

	public UserServiceModel getCreator() {
		return creator;
	}

	public void setCreator(UserServiceModel creator) {
		this.creator = creator;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public List<UserServiceModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserServiceModel> users) {
		this.users = users;
	}

	public List<MessageServiceModel> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageServiceModel> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "ChatServiceModel [id=" + id + ", name=" + name + ", isPrivate=" + isPrivate + ", createdAt="
				+ ", creator=" + creator + ", creatorId=" + creatorId + ", users=" + users + ", messages=" + messages
				+ "]";
	}
}
