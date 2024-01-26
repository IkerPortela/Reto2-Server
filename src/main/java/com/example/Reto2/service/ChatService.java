package com.example.Reto2.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.example.Reto2.model.ChatPostRequest;
import com.example.Reto2.model.ChatServiceModel;

public interface ChatService {

	List<ChatServiceModel> getAllChatsByUserId(Integer id);
	List<ChatServiceModel> getUserChats(Integer id);

	List<ChatServiceModel> getAllPrivateChats();
	List<ChatServiceModel> getAllPublicChats();
	ChatServiceModel createChat(Authentication authentication, ChatPostRequest chatPostRequest);
	ChatServiceModel updateChat(Integer id, ChatServiceModel request);
	void deleteChatById(Integer id);
	ChatServiceModel assignToChat(Authentication authentication, Integer chatId, Integer userId);
	ChatServiceModel joinChat(Integer chatId, Authentication authentication);
	ChatServiceModel leaveChat(Integer chatId, Authentication authentication);

}
