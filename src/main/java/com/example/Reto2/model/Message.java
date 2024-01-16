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
	private double latitude;
	@Column()
	private double longtitude;
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
	@JoinColumn(name = "group_id", foreignKey=@ForeignKey(name = "Fk_group_id"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Group group;
	
	@Column(name = "group_id", insertable=false, updatable=false)
	private Integer groupId;
	@Column()
	private String createdAt;
	@Column
	private String updatedAt;
	
	public Message() {}
	public Message(Integer id, String text, String imagePath, double latitude, double longtitude, boolean isSend,
			User user, Integer userId, Group group, Integer groupId, String createdAt, String updatedAt) {
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
		return "Message [id=" + id + ", text=" + text + ", imagePath=" + imagePath + ", latitude=" + latitude
				+ ", longtitude=" + longtitude + ", isSend=" + isSend + ", user=" + user + ", userId=" + userId
				+ ", group=" + group + ", groupId=" + groupId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	

}
