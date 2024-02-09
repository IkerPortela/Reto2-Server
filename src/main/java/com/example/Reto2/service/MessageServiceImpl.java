package com.example.Reto2.service;

import java.util.ArrayList;
import java.util.Date;
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
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	ChatRepository chatRepository;

	@Override
	public List<MessageServiceModel> getAllMessagesByChatId(Integer chatId) {
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		Chat chat = chatOptional.get();
		if (chat == null) {
			System.out.println("No se ha encontrado chat");

		}
		List<Message> messages = chat.getMessages();

		List<MessageServiceModel> response = new ArrayList<>();

		for (Message message : messages) {

			MessageServiceModel messageServiceModel = new MessageServiceModel();
			messageServiceModel.setId(message.getId());
			messageServiceModel.setText(message.getText());
			messageServiceModel.setImagePath(message.getImagePath());
			messageServiceModel.setSend(message.isSend());
			messageServiceModel.setUserId(message.getUserId());
			messageServiceModel.setChatId(message.getChatId());
			messageServiceModel.setCreated_at(message.getCreatedAt());

			response.add(messageServiceModel);
		}

		return response;

	}

	@Override
	public Message createMessage(Message message) {

		return messageRepository.save(message);
	}

	@Override
	public MessageServiceModel updateMessage(Message message) {
		return new MessageServiceModel(message.getId(), message.getText(), message.getImagePath(), message.isSend(),
				message.getUserId(), message.getChatId());
	}

	@Override
	public void deleteMessageById(Integer id) {
		messageRepository.deleteById(id);
	}

}
