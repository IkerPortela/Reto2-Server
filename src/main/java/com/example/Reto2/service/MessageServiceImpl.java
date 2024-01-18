package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto2.model.Chat;
import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;
import com.example.Reto2.repository.ChatRepository;
import com.example.Reto2.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	ChatRepository chatRepository;
	@Override
	public List<MessageServiceModel> getAllMessagesByChatId(Integer chatId) {
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		Chat chat = chatOptional.get();
		
		List<Message> messages = chat.getMessages();
		
		List<MessageServiceModel> response = new ArrayList<>();
		
		for(Message message : messages) {
	        MessageServiceModel messageServiceModel = new MessageServiceModel();
	        messageServiceModel.setId(message.getId());
	        messageServiceModel.setText(message.getText());
	        messageServiceModel.setImagePath(message.getImagePath());
	        messageServiceModel.setSend(message.isSend());
	        messageServiceModel.setUser(message.getUser());
	        messageServiceModel.setUserId(message.getUserId());
	        messageServiceModel.setChat(message.getChat());
	        messageServiceModel.setChatId(message.getChatId());
	        messageServiceModel.setCreatedAt(message.getCreatedAt());
	        messageServiceModel.setUpdatedAt(message.getUpdatedAt());
	        
	        response.add(messageServiceModel);
		}
		
		return response;
		
	}

	@Override
	public MessageServiceModel createMessage(Message message) {
	    return new MessageServiceModel(
		        message.getId(),
		        message.getText(),
		        message.getImagePath(),
		        message.isSend(),
		        message.getUser(),
		        message.getUserId(),
		        message.getChat(),
		        message.getChatId(),
		        message.getCreatedAt(),
		        message.getUpdatedAt()
	    		);
	}

	@Override
	public MessageServiceModel updateMessage(Message message) {
	    return new MessageServiceModel(
		        message.getId(),
		        message.getText(),
		        message.getImagePath(),
		        message.isSend(),
		        message.getUser(),
		        message.getUserId(),
		        message.getChat(),
		        message.getChatId(),
		        message.getCreatedAt(),
		        message.getUpdatedAt()
	    		);
	}

	@Override
	public void deleteMessageById(Integer id) {
		messageRepository.deleteById(id);
	}

}
