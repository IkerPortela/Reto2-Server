package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Reto2.model.Chat;
import com.example.Reto2.model.Role;
import com.example.Reto2.model.RoleEnum;
import com.example.Reto2.model.RoleServiceModel;
import com.example.Reto2.model.User;
import com.example.Reto2.model.UserPutRequest;
import com.example.Reto2.model.UserServiceModel;
import com.example.Reto2.repository.ChatRepository;
import com.example.Reto2.repository.RoleRepository;
import com.example.Reto2.repository.UserRepository;

@Service
public class UserServiceLmpl implements UserService, UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ChatRepository chatRepository;
	@Autowired
	RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public UserServiceModel create(User user) {
		List<Role> roles = new ArrayList<Role>();
		Role role = roleRepository.findByName(RoleEnum.PROFESOR.toString());
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
		
		return null;
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
				null);
    	List<Role> userRoles = response.getRoles();
    	List<RoleServiceModel> convertedRoleList = new ArrayList<>(); 
    	for(Role role : userRoles) {
    		RoleServiceModel roleServiceModel = new RoleServiceModel(
    				role.getId(),
    				role.getName()
    				);
    		convertedRoleList.add(roleServiceModel);
    	}
    			userServiceModel.setRoles(convertedRoleList);
		
		System.out.println(userServiceModel.toString());
		return userServiceModel;
	}

	public User update(User user) {
		User safe = new User(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				user.getName(),user.getSurname(),user.getPhone(),user.getDni(),user.getAddress());
		return userRepository.save(safe);
	}

	@Override
	public List<UserServiceModel> getAllUsersByChatId(Integer chatId) {
		
	    Chat chat = chatRepository.findById(chatId)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chat no encontrado"));
	    
	    List<User> chatUsers = chat.getUsers();
	    
	    List<UserServiceModel> response = new ArrayList<>();

	    for(User user : chatUsers) {
	    	UserServiceModel userServiceModel = new UserServiceModel(
	    			user.getId(),
	    			user.getEmail(),
	    			user.getPassword(),
	    			user.getName(),
	    			user.getSurname(),
	    			user.getAddress(),
	    			user.getPhone(),
	    			user.getDni(),
	    			null
	    			);
	    	
	    	List<Role> userRoles = user.getRoles();
	    	List<RoleServiceModel> convertedRoleList = new ArrayList<>(); 
	    	for(Role role : userRoles) {
	    		RoleServiceModel roleServiceModel = new RoleServiceModel(
	    				role.getId(),
	    				role.getName()
	    				);
	    		convertedRoleList.add(roleServiceModel);
	    	}
	    			userServiceModel.setRoles(convertedRoleList);
	    			response.add(userServiceModel);

	    }
	    return response;
	}

	@Override
	public UserServiceModel changePasswordLogged(Authentication authentication, UserPutRequest userPutRequest) {

		User userDetails = (User) authentication.getPrincipal();
		
		User user = userRepository.findById(userDetails.getId())
				.orElseThrow(() -> new UsernameNotFoundException(HttpStatus.NO_CONTENT + "not found"));
		
		String userEmail = user.getEmail();
		
		if(userEmail.equals(userPutRequest.getEmail())) {
			String encodedPassword = passwordEncoder.encode(userPutRequest.getPassword());
			user.setPassword(encodedPassword);
			userRepository.save(user);
		}
		
		UserServiceModel response = new UserServiceModel(
				user.getEmail(),
				user.getPassword());
		
		return response;
	}

	@Override
	public RoleServiceModel getUserRol(Integer id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException(HttpStatus.NO_CONTENT + "not found"));
		
		List<Role> userRoles = user.getRoles();
    	RoleServiceModel convertedRoleList = new RoleServiceModel(); 
    	for(Role role : userRoles) {
    		RoleServiceModel roleServiceModel = new RoleServiceModel(
    				role.getId(),
    				role.getName()
    		);
			convertedRoleList = roleServiceModel;

    	}
    	
		return convertedRoleList;
	}
}
