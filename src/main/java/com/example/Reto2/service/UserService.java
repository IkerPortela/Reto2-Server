package com.example.Reto2.service;

import com.example.Reto2.model.User;

public interface UserService {
	User create(User user);
	Iterable<User> findAll();
}
