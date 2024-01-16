package com.example.Reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto2.model.Message;
import com.example.Reto2.repository.MessageRepository;

@RestController
@RequestMapping("api")
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/messages")
	public ResponseEntity<Iterable<Message>> getMessages() {
		return new ResponseEntity<Iterable<Message>>(messageRepository.findAll(), HttpStatus.OK);
	}
}
