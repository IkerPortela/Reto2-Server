package com.example.Reto2.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.example.Reto2.model.RoleServiceModel;
import com.example.Reto2.model.User;
import com.example.Reto2.model.UserPutRequest;
import com.example.Reto2.model.UserServiceModel;

public interface UserService {
	UserServiceModel create(User user);
	Iterable<User> findAll();
	UserServiceModel findBy(Integer id);
	User update(User user);
	List<UserServiceModel> getAllUsersByChatId(Integer chatId);
	UserServiceModel changePasswordLogged(Authentication authentication, UserPutRequest userPutRequest);
	RoleServiceModel getUserRol(Integer id);
	
	
}
