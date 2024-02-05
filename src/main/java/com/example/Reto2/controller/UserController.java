package com.example.Reto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto2.model.UserServiceModel;
import com.example.Reto2.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users/chat")
	public ResponseEntity<List<UserServiceModel>> getUsersByChatId(@RequestParam Integer chatId){
		List<UserServiceModel> response = userService.getAllUsersByChatId(chatId);
		
		return new ResponseEntity<List<UserServiceModel>>(response,HttpStatus.OK); 
	}
	@GetMapping("/users/chat/count")
	public ResponseEntity<Integer> getCountOfUsers(@RequestParam Integer chatId){
		List<UserServiceModel> response = userService.getAllUsersByChatId(chatId);
		Integer count = response.size();
		return new ResponseEntity<Integer>(count,HttpStatus.OK); 
	}
}
