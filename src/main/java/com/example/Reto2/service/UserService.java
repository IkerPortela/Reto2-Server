package com.example.Reto2.service;

import java.util.List;

import com.example.Reto2.model.User;
import com.example.Reto2.model.UserServiceModel;

public interface UserService {
	UserServiceModel create(User user);
	Iterable<User> findAll();
	UserServiceModel findBy(Integer id);
	User update(User user);
	List<UserServiceModel> getAllUsersByChatId(Integer chatId);
	
}
