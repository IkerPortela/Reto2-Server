package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto2.model.Chat;
import com.example.Reto2.model.ChatPostRequest;
import com.example.Reto2.model.ChatServiceModel;
import com.example.Reto2.model.User;
import com.example.Reto2.repository.ChatRepository;
import com.example.Reto2.repository.UserRepository;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	ChatRepository chatRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public List<ChatServiceModel> getAllChatsByUserId(Integer userId) {
	    // Obtener el usuario por su ID
	    Optional<User> userOptional = userRepository.findById(userId);
	        User user = userOptional.get();
	        
	        List<Chat> chats = user.getChats();

	        List<ChatServiceModel> response = new ArrayList<>();

	        for (Chat chat : chats) {
	            ChatServiceModel chatServiceModel = new ChatServiceModel();
	            chatServiceModel.setId(chat.getId());
	            chatServiceModel.setName(chat.getName());
	            chatServiceModel.setPrivate(chat.isPrivate());
	            chatServiceModel.setCreatedAt(chat.getCreatedAt());
	            chatServiceModel.setUpdatedAt(chat.getUpdatedAt());
	            chatServiceModel.setUsers(chat.getUsers());
	            chatServiceModel.setMessages(chat.getMessages());

	            response.add(chatServiceModel);
	        }

	        return response;
	    } 
	@Override
	public List<ChatServiceModel> getAllPrivateChats() {
		Iterable<Chat> chatsById = chatRepository.findAll();
	    List<ChatServiceModel> response = new ArrayList<>();

	    for (Chat chat : chatsById) {
	    	if(chat.isPrivate()) {
	        ChatServiceModel chatServiceModel = new ChatServiceModel();
	        chatServiceModel.setId(chat.getId());
	        chatServiceModel.setName(chat.getName());
	        chatServiceModel.setPrivate(chat.isPrivate());
	        chatServiceModel.setCreatedAt(chat.getCreatedAt());
	        chatServiceModel.setUpdatedAt(chat.getUpdatedAt());
	        chatServiceModel.setUsers(chat.getUsers());
	        chatServiceModel.setMessages(chat.getMessages());
	        response.add(chatServiceModel);
	    	}
	    }

	    return response;
	}

	@Override
	public List<ChatServiceModel> getAllPublicChats() {
		Iterable<Chat> chatsById = chatRepository.findAll();
	    List<ChatServiceModel> response = new ArrayList<>();

	    for (Chat chat : chatsById) {
	    	if(chat.isPrivate() == false) {
	        ChatServiceModel chatServiceModel = new ChatServiceModel();
	        chat.getId();
	        chat.getName();
	        chat.isPrivate();
	        chat.getCreatedAt();
	        chat.getUpdatedAt();
	        chat.getUsers();
	        chat.getMessages();
	        response.add(chatServiceModel);
	    	}
	    }

	    return response;
	}

	@Override
	public ChatServiceModel createChat(ChatServiceModel chatServiceModel) {
		Chat chat = new Chat(chatServiceModel.getName(),chatServiceModel.isPrivate());
		Chat chatResponse = chatRepository.save(chat);
		ChatServiceModel response = new ChatServiceModel(
				chatResponse.getName(),
				chatResponse.isPrivate());
		return response ;
	
	}

	@Override
	public ChatServiceModel updateChat(Chat chat) {
		return new ChatServiceModel(
				chat.getId(),
				chat.getName(),
				chat.isPrivate(),
				chat.getCreatedAt(),
				chat.getUpdatedAt(),
				chat.getUsers(),
	    		chat.getMessages()
	    		);
	}

	@Override
	public void deleteChatById(Integer id) {
		chatRepository.deleteById(id);
	}

}
