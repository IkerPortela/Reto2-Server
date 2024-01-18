package com.example.Reto2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto2.model.Chat;
import com.example.Reto2.model.ChatPostRequest;
import com.example.Reto2.model.ChatServiceModel;
import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;
import com.example.Reto2.repository.ChatRepository;
import com.example.Reto2.service.ChatService;
import com.example.Reto2.service.MessageService;

@RestController
@RequestMapping("api")
public class ChatController {

	@Autowired
	private ChatService chatService;
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/chats/{userId}")
	public ResponseEntity<List<ChatServiceModel>> getChatsById(@PathVariable("userId") Integer userId) {
	    List<ChatServiceModel> response = new ArrayList<>();

	    for (ChatServiceModel chatModelService : chatService.getAllChatsByUserId(userId)) {
	        List<MessageServiceModel> messages = messageService.getAllMessagesByChatId(chatModelService.getId());

	        List<Message> convertedMessages = new ArrayList<>();
	        for (MessageServiceModel messageServiceModel : messages) {
	            Message message = new Message();
	            message.setText(messageServiceModel.getText());
	            message.setImagePath(messageServiceModel.getImagePath());
	            message.setSend(messageServiceModel.isSend());
	            message.setUser(messageServiceModel.getUser());
	            message.setUserId(messageServiceModel.getUserId());
	            message.setChat(messageServiceModel.getChat());
	            message.setChatId(messageServiceModel.getChatId());
	            message.setCreatedAt(messageServiceModel.getCreatedAt());
	            message.setUpdatedAt(messageServiceModel.getUpdatedAt());

	            convertedMessages.add(message);
	        }

	        chatModelService.setMessages(convertedMessages);
	        response.add(chatModelService);
	    }

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
//	@PostMapping("/chats")
//	public ResponseEntity<ChatServiceModel> createChat(@RequestBody ChatPostRequest chatPostRequest){
//		
//		
//	}
}
