package com.example.Reto2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chats")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column()
	private String name;
	@Column()
	private boolean isPrivate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creator_id", foreignKey=@ForeignKey(name = "Fk_user_id"))
	@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User creator;
	
	@Column(name="creator_id", insertable=false, updatable=false)
	private Integer creatorId;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "chats_users",
            joinColumns = @JoinColumn(name = "chat_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_chat_id")),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_id")))
    @JsonIgnore
    @JsonManagedReference
    private List<User> users;
    
    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference
    private List<Message> messages;
    
    public Chat() {}
     
	public Chat(String name, boolean isPrivate, User creator) {
		super();
		this.name = name;
		this.isPrivate = isPrivate;
		this.creator = creator;
	}

	public Chat(Integer id, String name, boolean isPrivate, User creator, Integer creatorId, List<User> users, List<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.creator = creator;
		this.creatorId = creatorId;
		this.users = users;
		this.messages = messages;
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
		return "Chat [id=" + id + ", name=" + name + ", isPrivate=" + isPrivate + ", creator=" + creator
				+ ", creatorId=" + creatorId +  ", users="
				+ users + ", messages=" + messages + "]";
	}
}
