package com.example.Reto2.service;

import java.util.Date;
import java.util.List;

import com.example.Reto2.model.Message;
import com.example.Reto2.model.MessageServiceModel;

public interface MessageService {

	List<MessageServiceModel> getAllMessagesByChatId(Integer integer);
	Message createMessage(Message message);
	MessageServiceModel updateMessage(Message message);
	void deleteMessageById(Integer id);

	List<MessageServiceModel> getMessagesInOrder(Date created_at);
	
}
