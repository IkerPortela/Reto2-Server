package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.Reto2.model.RoleServiceModel;
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
	public List<ChatServiceModel> getUserChats(Integer id) {
		List<ChatServiceModel> ret = new ArrayList<ChatServiceModel>();

		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();

		for (Chat chat : user.getChats()) {
			ChatServiceModel chatServiceModel = new ChatServiceModel();
			chatServiceModel.setId(chat.getId());
			chatServiceModel.setName(chat.getName());
			chatServiceModel.setPrivate(chat.isPrivate());
			ret.add(chatServiceModel);
		}

		return ret;
	}

	@Override
	public List<ChatServiceModel> getAllChatsByUserId(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));
        List<ChatServiceModel> ret = new ArrayList<>();

        for (Chat chat : user.getChats()) {
            
            ret = null == ret? new ArrayList<ChatServiceModel> () : ret;
            

            ret = null == ret ? new ArrayList<ChatServiceModel>() : ret;

            ChatServiceModel chatServiceModel = new ChatServiceModel(
                    chat.getId(),
                    chat.getName(),
                    chat.isPrivate(),
                    chat.getCreatorId()
                    );
            
            List<Message> chatMessages = chat.getMessages();
            List<MessageServiceModel> convertedMessages = new ArrayList<>();
            
            for(Message message : chatMessages) {
                MessageServiceModel messageServiceModel = new MessageServiceModel(
                        message.getId(),
                        message.getText(),
                        message.isSend(),
                        message.getUserId(),
                        message.getChatId()
                        );
                convertedMessages.add(messageServiceModel);
            }
            chatServiceModel.setMessage(mensajeReciente(convertedMessages));

            ret.add(chatServiceModel);
        }

        return ret;
    }

	private MessageServiceModel mensajeReciente(List<MessageServiceModel> messages) {
		MessageServiceModel ret = null;

		if (!messages.isEmpty()) {
			ret = messages.get(messages.size() - 1);

			for (MessageServiceModel message : messages) {
				System.out.println(message.toString());
			}
		} else {
			System.out.println("La lista de mensajes es nula o vacía");
		}

		return ret;
	}

	@Override
	public List<ChatServiceModel> getAllPrivateChats() {
		Iterable<Chat> chatsById = chatRepository.findAll();
		List<ChatServiceModel> response = new ArrayList<>();

		for (Chat chat : chatsById) {
			if (chat.isPrivate()) {
				ChatServiceModel chatServiceModel = new ChatServiceModel(chat.getId(), chat.getName(), chat.isPrivate(),
						chat.getCreatorId());
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
				ChatServiceModel chatServiceModel = new ChatServiceModel(chat.getId(), chat.getName(),
						chat.isPrivate());

				response.add(chatServiceModel);
			}
		}

		return response;
	}

	@Override
	public ChatServiceModel createChat(Authentication authentication, ChatPostRequest chatPostRequest) {
		User creator = (User) authentication.getPrincipal();

		User user = userRepository.findById(chatPostRequest.getCreatorId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));

		List<Role> userRoles = new ArrayList<>();
		userRoles = user.getRoles();
		if (!chatPostRequest.isPrivate()) {
			Chat chat = new Chat(chatPostRequest.getName(), chatPostRequest.isPrivate(), creator);
			UserServiceModel convertedUser = new UserServiceModel(user.getId(), user.getEmail());
			List<User> creatorInChat = new ArrayList<>();
			creatorInChat.add(user);
			chat.setUsers(creatorInChat);
			chatRepository.save(chat);

			ChatServiceModel response = new ChatServiceModel(chat.getName(), chat.isPrivate(), convertedUser,
					convertedUser.getId());

			return response;
		} else {
			for (Role role : userRoles) {
				if (role.getName().equals("Profesor")) {
					Chat chat = new Chat(chatPostRequest.getName(), chatPostRequest.isPrivate(), creator);
					UserServiceModel convertedUser = new UserServiceModel(user.getId(), user.getEmail());
					List<User> creatorInChat = new ArrayList<>();
					creatorInChat.add(user);
					chat.setUsers(creatorInChat);
					chatRepository.save(chat);

					ChatServiceModel response = new ChatServiceModel(chat.getName(), chat.isPrivate(), convertedUser,
							convertedUser.getId());
					return response;
				}

				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"Solo los profesores tienen permiso para hacer chats privados");

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
		ChatServiceModel response = new ChatServiceModel(chat.getId(), chat.getName(), chat.isPrivate(),
				chat.getCreatorId());

		return response;
	}

	@Override
	public void deleteChatById(Integer chatId, Authentication authentication) {
		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chat no encontrado"));

		User userDetails = (User) authentication.getPrincipal();
		User user = userRepository.findById(userDetails.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

		List<Role> userRoles = user.getRoles();

		for (Role role : userRoles) {
			if (role.getName().equals("Estudiante") && chat.getCreatorId().equals(user.getId())) {
				if (!chat.isPrivate()) {
					chatRepository.deleteById(chatId);
					return;
				}
			} else if (role.getName().equals("Profesor")) {
				if (!chat.isPrivate() || (chat.isPrivate() && chat.getCreatorId().equals(user.getId()))) {
					chatRepository.deleteById(chatId);
					return;
				}
			}
		}

		throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tienes permisos para eliminar este chat");
	}

	@Override
	public ChatServiceModel assignToChat(Authentication authentication, Integer chatId, Integer userId) {

		User userDetails = (User) authentication.getPrincipal();
		UserServiceModel teacher = userService.findBy(userDetails.getId());

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));

		List<RoleServiceModel> teacherRoles = teacher.getRoles();

		for (RoleServiceModel roleServiceModel : teacherRoles) {
			if (roleServiceModel.getName().equals("Profesor")) {
				chat.getUsers().add(user);
				chatRepository.save(chat);
			} else {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"No tienes permisos para asignar a un usuario en este chat");
			}

		}

		ChatServiceModel response = new ChatServiceModel(chat.getId(), chat.getName(), chat.isPrivate(),
				chat.getCreatorId());
		return response;
	}

	@Override
	public ChatServiceModel disassignFromChat(Authentication authentication, Integer chatId, Integer userId) {

		User userDetails = (User) authentication.getPrincipal();
		UserServiceModel teacher = userService.findBy(userDetails.getId());

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));

		List<RoleServiceModel> teacherRoles = teacher.getRoles();

		for (RoleServiceModel role : teacherRoles) {
			if (role.getName().equals("Profesor")) {
				chat.getUsers().remove(user);
				chatRepository.save(chat);
			} else {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"No tienes permisos para asignar a un usuario en este chat");
			}

		}

		ChatServiceModel response = new ChatServiceModel(chat.getId(), chat.getName(), chat.isPrivate(),
				chat.getCreatorId());
		return response;
	}



	@Override
	public ChatServiceModel joinChat(Integer chatId, Authentication authentication) {

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User userDetails = (User) authentication.getPrincipal();
		UserServiceModel user = userService.findBy(userDetails.getId());

		User addUser = new User(user.getId(), user.getEmail(), user.getPassword());

		chat.getUsers().add(addUser);
		chatRepository.save(chat);
		return null;
	}

	

	@Override
	public ChatServiceModel leaveChat(Integer chatId, Authentication authentication) {

		Chat chat = chatRepository.findById(chatId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Chat no encontrado"));

		User userDetails = (User) authentication.getPrincipal();
		User user = userRepository.findById(userDetails.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Usuario no encontrado"));

		List<User> updatedList = new ArrayList<>();
		List<User> chatWithUsers = chat.getUsers();

		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if (role.getName().equals("Estudiante") && chat.isPrivate() == false) {
				for (User chatUser : chatWithUsers) {
					if (!chatUser.getId().equals(user.getId())) {
						updatedList.add(chatUser);
					}
				}
			} else if (role.getName().equals("Estudiante") && chat.isPrivate() == true) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tienes permisos para salirte de este chat");

			} else if (role.getName().equals("Profesor")) {
				for (User chatUser : chatWithUsers) {
					if (!chatUser.getId().equals(user.getId())) {
						updatedList.add(chatUser);
					}
				}
			}
		}

		chat.setUsers(updatedList);
		chatRepository.save(chat);
		return null;
	}

}
