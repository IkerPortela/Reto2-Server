package com.example.Reto2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;
import com.example.Reto2.model.User;
import com.example.Reto2.model.UserServiceModel;
import com.example.Reto2.service.ChatService;
import com.example.Reto2.service.MessageService;
import com.example.Reto2.service.UserService;

@RestController
@RequestMapping("api")
public class ChatController {

	@Autowired
	private ChatService chatService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	@GetMapping("/chats/userChats")
	public ResponseEntity<List<ChatServiceModel>> getChatsById(Authentication authentication) {
		
		User userDetails = (User) authentication.getPrincipal();
		List<ChatServiceModel> response = new ArrayList<>();
		response = chatService.getAllChatsByUserId(userDetails.getId());


		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/chats")
	public ResponseEntity<List<ChatServiceModel>> getUserChatsByAuth(Authentication authentication) {
		User userDetails = (User) authentication.getPrincipal();
		List<ChatServiceModel> response = chatService.getUserChats(userDetails.getId());


		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/chats/public")
	public ResponseEntity<List<ChatServiceModel>> getPublicChats() {
		List<ChatServiceModel> response = chatService.getAllPublicChats();
		return new ResponseEntity<List<ChatServiceModel>>(response, HttpStatus.CREATED);
	}

	@PostMapping("/chats")
	public ResponseEntity<ChatServiceModel> createChat(@RequestBody ChatPostRequest request,
			Authentication authentication) {
		User creatorDetails = (User) authentication.getPrincipal();
		UserServiceModel creator = userService.findBy(creatorDetails.getId());
		request.setCreatorId(creator.getId());
		ChatServiceModel result = chatService.createChat(authentication, request);
		return new ResponseEntity<ChatServiceModel>(result, HttpStatus.CREATED);
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

	@DeleteMapping("/chats/delete")
	public ResponseEntity<Integer> deleteChat(@RequestParam Integer chatId, Authentication authentication) {
		chatService.deleteChatById(chatId, authentication);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@DeleteMapping("/chats/leave")
	public ResponseEntity<?> userLeaveChat(@RequestParam Integer chatId, Authentication authentication) {
		chatService.leaveChat(chatId, authentication);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/chats/noPrivate")
	public ResponseEntity<List<ChatServiceModel>> getChatNoPrivate(Authentication authentication) {
		User userDetails = (User) authentication.getPrincipal();
		List<ChatServiceModel> allPublicChats = chatService.getAllPublicChats();
		List<ChatServiceModel> userChats = chatService.getUserChats(userDetails.getId());

		List<ChatServiceModel> publicChatsNotInUser = allPublicChats.stream().filter(chat -> !userChats.contains(chat))
				.collect(Collectors.toList());
		System.out.println(publicChatsNotInUser.toString());
		return new ResponseEntity<>(publicChatsNotInUser, HttpStatus.OK);
	}

	@DeleteMapping("/chats/disassign")
	public ResponseEntity<?> disassignUserFromChat(Authentication authentication,
			@RequestParam Integer chatId, @RequestParam Integer userId){
			chatService.disassignFromChat(authentication, chatId, userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
