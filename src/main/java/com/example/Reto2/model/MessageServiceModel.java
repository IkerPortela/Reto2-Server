package com.example.Reto2.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MessageServiceModel {

	private Integer id;
	private String text;
	private String imagePath;
	private boolean isSend;
	private Date created_at;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer userId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer chatId;

	
	public MessageServiceModel() {}
	
	

	public MessageServiceModel(Integer id, String text, String imagePath, boolean isSend, Date created_at,
			Integer userId, Integer chatId) {
		super();
		this.id = id;
		this.text = text;
		this.imagePath = imagePath;
		this.isSend = isSend;
		this.created_at = created_at;
		this.userId = userId;
		this.chatId = chatId;
	}



	public MessageServiceModel(Integer id, String text,
			boolean isSend,  Integer userId,  Integer chatId) {
		super();
		this.id = id;
		this.text = text;
		this.isSend = isSend;
		this.userId = userId;
		this.chatId = chatId;
	
	}
	
	public MessageServiceModel(Integer id, String text, String imagePath,
			boolean isSend,  Integer userId,  Integer chatId) {
		super();
		this.id = id;
		this.text = text;
		this.imagePath = imagePath;
		this.isSend = isSend;
		this.userId = userId;
		this.chatId = chatId;
	
	}

	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
		return "MessageServiceModel [id=" + id + ", text=" + text + ", imagePath=" + imagePath + ", isSend=" + isSend + ", userId="
				+ userId + ", chatId=" + chatId  + "]";
	}
	
}
