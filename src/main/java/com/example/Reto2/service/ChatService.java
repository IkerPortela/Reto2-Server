package com.example.Reto2.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.example.Reto2.model.ChatServiceModel;

public interface ChatService {

	List<ChatServiceModel> getAllChatsByUserId(Integer id);
	List<ChatServiceModel> getAllPrivateChats();
	List<ChatServiceModel> getAllPublicChats();
	ChatServiceModel createChat(ChatServiceModel chat);
	ChatServiceModel updateChat(Integer id, ChatServiceModel request);
	void deleteChatById(Integer id);
	ChatServiceModel assignToChat(Integer teacherId, Integer chatId, Integer userId);
	ChatServiceModel joinToChat(Integer chatId, Integer userId);
	ChatServiceModel leaveChat(Integer chatId, Authentication authentication);

}
