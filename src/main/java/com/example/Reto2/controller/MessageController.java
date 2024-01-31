package com.example.Reto2.controller;

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

import com.example.Reto2.model.ChatPostRequest;
import com.example.Reto2.model.ChatServiceModel;
import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;
import com.example.Reto2.repository.MessageRepository;
import com.example.Reto2.service.MessageService;

@RestController
@RequestMapping("api")
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private MessageService messageService;
	@GetMapping("/messages")
	public ResponseEntity<Iterable<Message>> getMessages() {
		return new ResponseEntity<Iterable<Message>>(messageRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/messages/{chatId}")
	public ResponseEntity<List<MessageServiceModel>> getMessagesByChat(@PathVariable("chatId") int chatid) {
		return new ResponseEntity<List<MessageServiceModel>>(messageService.getAllMessagesByChatId(chatid), HttpStatus.OK);
	}
	


}
