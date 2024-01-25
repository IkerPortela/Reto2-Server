package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Reto2.model.Chat;
import com.example.Reto2.model.ChatPostRequest;
import com.example.Reto2.model.ChatServiceModel;
import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;
import com.example.Reto2.model.Role;
import com.example.Reto2.model.User;
import com.example.Reto2.model.UserServiceModel;
import com.example.Reto2.repository.ChatRepository;
import com.example.Reto2.repository.UserRepository;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	ChatRepository chatRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@Override
<<<<<<< HEAD
	public List<ChatServiceModel> getAllChatsByUserId(Authentication authentication) {

		User userDetails = (User) authentication.getPrincipal();
		User user = userRepository.findById(userDetails.getId()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado")
				);
		List<Chat> chats = user.getChats();

		List<ChatServiceModel> response = new ArrayList<>();

		for (Chat chat : chats) {
=======
	public List<ChatServiceModel> getAllChatsByUserId(Integer userId) {
		
		List<ChatServiceModel> ret = null;

		Optional<User> userOptional = userRepository.findById(userId);
		User user = userOptional.get();

		for (Chat chat : user.getChats()) {
			
			ret = null == ret? new ArrayList<ChatServiceModel> () : ret;
			
>>>>>>> 3c6cb3d8e908fb0c56a48f4380f369cd20466385
			ChatServiceModel chatServiceModel = new ChatServiceModel();
			chatServiceModel.setId(chat.getId());
			chatServiceModel.setName(chat.getName());
			chatServiceModel.setPrivate(chat.isPrivate());
<<<<<<< HEAD
			chatServiceModel.setCreator(chat.getCreator());
			chatServiceModel.setCreatorId(chat.getCreatorId());
			chatServiceModel.setUsers(chat.getUsers());
			chatServiceModel.setMessages(chat.getMessages());

			response.add(chatServiceModel);
=======
			chatServiceModel.setMessage(mensajeReciente(chat.getMessages()));
			
			ret.add(chatServiceModel);
>>>>>>> 3c6cb3d8e908fb0c56a48f4380f369cd20466385
		}

		return ret;
	}

	private Message mensajeReciente(List<Message> messages) {
		Message ret = null;
		if (!messages.isEmpty()) {
			ret = messages.get(messages.size() - 1);
			for (Message message : messages) {
				System.out.println(message.toString());
			}
		} else {
			System.out.println("La lista de mensajes ses nula o vacía");
		}
		return ret;
	}

	@Override
	public List<ChatServiceModel> getAllPrivateChats() {
		Iterable<Chat> chatsById = chatRepository.findAll();
		List<ChatServiceModel> response = new ArrayList<>();

		for (Chat chat : chatsById) {
			if (chat.isPrivate()) {
				ChatServiceModel chatServiceModel = new ChatServiceModel();
				chatServiceModel.setId(chat.getId());
				chatServiceModel.setName(chat.getName());
				chatServiceModel.setPrivate(chat.isPrivate());
				chatServiceModel.setCreator(chat.getCreator());
				chatServiceModel.setCreatorId(chat.getCreatorId());
				chatServiceModel.setUsers(chat.getUsers());
				chatServiceModel.setMessages(chat.getMessages());
				response.add(chatServiceModel);
			}
		}

		return response;
	}

	@Override
	public List<ChatServiceModel> getAllPublicChats() {
		Iterable<Chat> chatsById = chatRepository.findAll();
		List<ChatServiceModel> response = new ArrayList<>();

		for (Chat chat : chatsById) {
			if (chat.isPrivate() == false) {
				ChatServiceModel chatServiceModel = new ChatServiceModel();
				chat.getId();
				chat.getName();
				chat.getUsers();
				chat.getMessages();
				response.add(chatServiceModel);
			}
		}

		return response;
	}

	@Override
	public ChatServiceModel createChat(Authentication authentication, ChatPostRequest chatPostRequest) {
		User creator = (User) authentication.getPrincipal();
		
		User user = userRepository.findById(chatPostRequest.getCreatorId()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado")
				);
		
		List<Role> userRoles = new ArrayList<>();
		userRoles = user.getRoles();
		if (!chatPostRequest.isPrivate()) {
			Chat chat = new Chat(
					chatPostRequest.getName(), 
					chatPostRequest.isPrivate(), 
					creator
					);	
			List<User> creatorInChat = new ArrayList<>();
			creatorInChat.add(user);
			chat.setUsers(creatorInChat);
			chatRepository.save(chat);

			ChatServiceModel response = new ChatServiceModel(
					null,
					chat.getName(), 
					chat.isPrivate(), 
					null,
					chat.getCreatorId(),
					chat.getUsers(),
					chat.getMessages()
					);

			return response;
		}else {
			for(Role role : userRoles) {
				if(role.getName().equals("Profesor")) {
					Chat chat = new Chat(
							chatPostRequest.getName(), 
							chatPostRequest.isPrivate(), 
							creator
							);
					List<User> creatorInChat = new ArrayList<>();
					creatorInChat.add(user);
					chat.setUsers(creatorInChat);
					chatRepository.save(chat);

					ChatServiceModel response = new ChatServiceModel(
							null,
							chat.getName(), 
							chat.isPrivate(), 
							null,
							chat.getCreatorId(),
							chat.getUsers(),
							chat.getMessages()
							);
					return response;
				}
			}
			return null;

			
		}
		

	}

	@Override
	public ChatServiceModel updateChat(Integer id, ChatServiceModel request) {
		Chat chat = chatRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));
		if (request.getName() != null) {
			chat.setName(request.getName());
		}

		chat = chatRepository.save(chat);
		ChatServiceModel response = new ChatServiceModel(
				chat.getId(), 
				chat.getName(), 
				chat.isPrivate(), 
				chat.getCreator(), 
				chat.getCreatorId(),
				chat.getUsers(), 
				chat.getMessages()
				);

		return response;
	}

	@Override
	public void deleteChatById(Integer id) {
		Chat chat = chatRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		chatRepository.deleteById(id);
	}

	@Override
	public ChatServiceModel assignToChat(Authentication authentication, Integer chatId, Integer userId) {

		User userDetails = (User) authentication.getPrincipal();
		UserServiceModel teacher = userService.findBy(userDetails.getId());

<<<<<<< HEAD
			
			ChatServiceModel response = new ChatServiceModel(
					chat.getId(), 
					chat.getName(), 
					chat.isPrivate(),
					chat.getCreator(), 
					chat.getCreatorId(),
					chat.getUsers(), 
					chat.getMessages()
					);
	return response;
	}
=======
		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));

		List<Role> teacherRoles = teacher.getRoles();

		for (Role role : teacherRoles) {
			if (role.getName().equals("Profesor")) {
				chat.getUsers().add(user);
				chatRepository.save(chat);
			} // TODO Manejar el caso de que no tenga un rol de profesor

		}

		ChatServiceModel response = new ChatServiceModel(chat.getId(), chat.getName(), chat.isPrivate(),
				chat.getCreatedAt(), chat.getUpdatedAt(), chat.getUsers(), chat.getMessages());
		return response;
	}

	public ChatServiceModel assignToChat(Integer teacherId, Integer chatId, Integer userId) {

		User teacher = userRepository.findById(teacherId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario agregador no encontrado"));

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));
		List<Role> teacherRoles = teacher.getRoles();

		for (Role role : teacherRoles) {
			if (role.getName().equals("Profesor")) {
				chat.getUsers().add(user);
				chatRepository.save(chat);
			}

		}

		ChatServiceModel response = new ChatServiceModel(chat.getId(), chat.getName(), chat.isPrivate(),
				chat.getCreatedAt(), chat.getUpdatedAt(), chat.getUsers(), chat.getMessages());

		return response;
	}
>>>>>>> 3c6cb3d8e908fb0c56a48f4380f369cd20466385

	@Override
	public ChatServiceModel joinChat(Integer chatId, Authentication authentication) {

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User userDetails = (User) authentication.getPrincipal();
		UserServiceModel user = userService.findBy(userDetails.getId());
<<<<<<< HEAD
		
		User addUser = new User(
				user.getId(),
				user.getEmail(),
				user.getPassword());
	
	    	chat.getUsers().add(addUser);
	    	return null;
=======
		User addUser = new User(user.getId(), user.getEmail(), user.getPassword());

		chat.getUsers().add(addUser);
		return null;
>>>>>>> 3c6cb3d8e908fb0c56a48f4380f369cd20466385
	}

	public ChatServiceModel joinToChat(Integer chatId, Integer userId) {

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));

		chat.getUsers().add(user);
		chatRepository.save(chat);
		ChatServiceModel response = new ChatServiceModel(
				chat.getId(), 
				chat.getName(), 
				chat.isPrivate(),
				chat.getCreator(), 
				chat.getCreatorId(),
				chat.getUsers(), 
				chat.getMessages()
				);

		return response;
	}

	@Override
	public ChatServiceModel leaveChat(Integer chatId, Authentication authentication) {

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User userDetails = (User) authentication.getPrincipal();
		UserServiceModel user = userService.findBy(userDetails.getId());

		List<User> updatedList = new ArrayList<>();
		List<User> chatWithUsers = chat.getUsers();
		for (User chatUser : chatWithUsers) {
			if (!chatUser.getId().equals(user.getId())) {
				updatedList.add(chatUser);
			}
		}

		chat.setUsers(updatedList);
		chatRepository.save(chat);
		return null;
	}
}
