package com.example.Reto2.service;

import java.util.List;

import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;

public interface MessageService {

	List<MessageServiceModel> getAllMessagesByChatId(Integer integer);
	MessageServiceModel createMessage(Message message);
	MessageServiceModel updateMessage(Message message);
	void deleteMessageById(Integer id);
}
