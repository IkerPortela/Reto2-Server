package com.example.Reto2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column()
	private String text;
	@Column()
	private String imagePath;
	@Column()
	private boolean isSend;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey=@ForeignKey(name = "Fk_user_id"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_id", foreignKey=@ForeignKey(name = "Fk_chat_id"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Chat chat;
	
	@Column(name = "chat_id", insertable=false, updatable=false)
	private Integer chatId;
	@Column()
	private String createdAt;
	@Column
	private String updatedAt;
	
	public Message() {}

	public Message(Integer id, String text, String imagePath, boolean isSend,
			User user, Integer userId, Chat chat, Integer chatId, String createdAt, String updatedAt) {
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
		return "Message [id=" + id + ", text=" + text + ", imagePath=" + imagePath  + ", isSend=" + isSend + ", user=" + user + ", userId=" + userId
				+ ", chat=" + chat + ", chatId=" + chatId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	
	

}
