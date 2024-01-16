package com.example.Reto2.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MessageServiceModel {

	private Integer id;
	private String text;
	private String imagePath;
	private double latitude;
	private double longtitude;
	private boolean isSend;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User user;
	private Integer userId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Group group;
	private Integer groupId;
	
	private String createdAt;
	private String updatedAt;
	
	public MessageServiceModel() {}
	public MessageServiceModel(Integer id, String text, String imagePath, double latitude, double longtitude,
			boolean isSend, User user, Integer userId, Group group, Integer groupId, String createdAt,
			String updatedAt) {
		super();
		this.id = id;
		this.text = text;
		this.imagePath = imagePath;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.isSend = isSend;
		this.user = user;
		this.userId = userId;
		this.group = group;
		this.groupId = groupId;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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
		return "MessageServiceModel [id=" + id + ", text=" + text + ", imagePath=" + imagePath + ", latitude="
				+ latitude + ", longtitude=" + longtitude + ", isSend=" + isSend + ", user=" + user + ", userId="
				+ userId + ", group=" + group + ", groupId=" + groupId + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
}
