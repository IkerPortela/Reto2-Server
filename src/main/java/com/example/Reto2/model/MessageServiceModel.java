package com.example.Reto2.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MessageServiceModel {

	private Integer id;
	private String text;
	private String imagePath;
	private boolean isSend;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User user;
	private Integer userId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Chat chat;
	private Integer chatId;
	
	private String createdAt;
	private String updatedAt;
	
	public MessageServiceModel() {}

	public MessageServiceModel(Integer id, String text, String imagePath,
			boolean isSend, User user, Integer userId, Chat chat, Integer chatId, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.text = text;
		this.imagePath = imagePath;
		this.isSend = isSend;
		this.user = user;
		this.userId = userId;
		this.chat = chat;
		this.chatId = chatId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isSend() {
		return isSend;
	}

	public void setSend(boolean isSend) {
		this.isSend = isSend;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
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

	@Override
	public String toString() {
		return "MessageServiceModel [id=" + id + ", text=" + text + ", imagePath=" + imagePath + ", isSend=" + isSend + ", user=" + user + ", userId="
				+ userId + ", chat=" + chat + ", chatId=" + chatId + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
}
