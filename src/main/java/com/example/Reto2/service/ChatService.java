package com.example.Reto2.service;

import java.util.List;

import com.example.Reto2.model.Chat;
import com.example.Reto2.model.ChatServiceModel;

public interface ChatService {

	List<ChatServiceModel> getAllChatsByUserId(Integer id);
	List<ChatServiceModel> getAllPrivateChats();
	List<ChatServiceModel> getAllPublicChats();
	ChatServiceModel createChat(ChatServiceModel chat);
	ChatServiceModel updateChat(Chat chat);
	void deleteChatById(Integer id);
}
