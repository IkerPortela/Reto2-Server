package com.example.Reto2.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/lastMessages")
	public ResponseEntity<List<MessageServiceModel>> getChatLastMessages(@RequestParam("created_at") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")String androidDate ) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date create_at = new Date();
		try {
			create_at = formato.parse(androidDate);
		} catch (ParseException e) {
		
		}
		return new ResponseEntity<List<MessageServiceModel>>(messageService.getMessagesInOrder(create_at), HttpStatus.OK);
	}
	

}
