package com.example.Reto2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto2.model.ChatPostRequest;
import com.example.Reto2.model.ChatServiceModel;
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


			response.add(chatModelService);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/chats")
	public ResponseEntity<ChatServiceModel> createChat(@RequestBody ChatPostRequest request) {
		ChatServiceModel chat = new ChatServiceModel(request.getName(), request.isPrivate());
		chatService.createChat(chat);
		return new ResponseEntity<ChatServiceModel>(chat, HttpStatus.CREATED);
	}

	@PostMapping("/chats/assign")
	public ResponseEntity<ChatServiceModel> assignUserToChat(Authentication authentication,
			@RequestParam Integer chatId, @RequestParam Integer userId) {
		ChatServiceModel result = chatService.assignToChat(authentication, chatId, userId);
		return new ResponseEntity<ChatServiceModel>(result, HttpStatus.OK);
	}

	@PostMapping("/chats/join")
	public ResponseEntity<ChatServiceModel> joinUserToChat(@RequestParam Integer chatId,
			Authentication authentication) {
		ChatServiceModel result = chatService.joinChat(chatId, authentication);
		return new ResponseEntity<ChatServiceModel>(result, HttpStatus.OK);
	}

	@PutMapping("/chats/{id}")
	public ResponseEntity<ChatServiceModel> updateChat(@PathVariable("id") Integer id,
			@RequestBody ChatPostRequest request) {
		ChatServiceModel chat = new ChatServiceModel(request.getName(), request.isPrivate());
		ChatServiceModel response = chatService.updateChat(id, chat);
		return new ResponseEntity<ChatServiceModel>(response, HttpStatus.OK);
	}

	@DeleteMapping("/chats/{id}")
	public ResponseEntity<?> deleteChat(@PathVariable("id") Integer id) {
		chatService.deleteChatById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/chats/leave")
	public ResponseEntity<?> userLeaveChat(@RequestParam Integer chatId, Authentication authentication) {
		chatService.leaveChat(chatId, authentication);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
