package com.example.Reto2.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Reto2.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	Role findByName(String name);
}
