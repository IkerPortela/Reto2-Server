package com.example.Reto2.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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
	@Column()
	private Integer userId;

	@Column()
	private Integer chatId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	private Date createdAt;

	public Message() {
	}

	public Message(Integer id, String text, String imagePath, boolean isSend, Integer userId, Integer chatId) {
		super();
		this.id = id;
		this.text = text;
		this.imagePath = imagePath;
		this.isSend = isSend;
		this.userId = userId;
		this.chatId = chatId;

	}

	public Message(String text, boolean isSend, Integer userId, Integer chatId) {
		super();
		this.text = text;
		this.isSend = isSend;
		this.userId = userId;
		this.chatId = chatId;
	}

	public Message(Integer id, String text, String imagePath, boolean isSend, Integer userId, Integer chatId,
			Date createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.imagePath = imagePath;
		this.isSend = isSend;
		this.userId = userId;
		this.chatId = chatId;
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", imagePath=" + imagePath + ", isSend=" + isSend + ", userId="
				+ userId + " chatId =" + chatId + "]";
	}

}
