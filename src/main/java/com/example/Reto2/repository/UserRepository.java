package com.example.Reto2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Reto2.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByEmail(String email);

}