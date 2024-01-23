package com.example.Reto2.service;

import com.example.Reto2.model.User;
import com.example.Reto2.model.UserServiceModel;

public interface UserService {
	User create(User user);
	Iterable<User> findAll();
	UserServiceModel findBy(Integer id);
	User update(User user);
}
