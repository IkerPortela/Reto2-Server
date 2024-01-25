package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Reto2.model.Role;
import com.example.Reto2.model.RoleEnum;
import com.example.Reto2.model.User;
import com.example.Reto2.model.UserServiceModel;
import com.example.Reto2.repository.RoleRepository;
import com.example.Reto2.repository.UserRepository;

@Service
public class UserServiceLmpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public User create(User user) {
		List<Role> roles = new ArrayList<Role>();
		Role role = roleRepository.findByName(RoleEnum.PROFESOR.toString());
		roles.add(role);
		user.setRoles(roles);

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// esta es la funcion que busca al usuario por email.
		// ya que en este caso el campo de login es el email
		// si fuese otro, realizar otra funcion
		return userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserServiceModel findBy(Integer id) {
		User response = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException(HttpStatus.NO_CONTENT + "not found"));
		UserServiceModel userServiceModel = new UserServiceModel(
				response.getId(),
				response.getEmail(),
				response.getPassword(),
				response.getName(),
				response.getSurname(),
				response.getAddress(),
				response.getPhone(),
				response.getDni(),
				response.getRoles());
		System.out.println(userServiceModel.toString());
		return userServiceModel;
	}

	public User update(User user) {
		return userRepository.save(user);
	}
}
