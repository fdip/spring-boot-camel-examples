package com.pionieerlabs.app.messages;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class MessageService {
	private final MessageRepository messageRepository;

	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	public Message save(Message message) {
		Message savedMessage = messageRepository.save(message);
		log.info("Received message: {}", savedMessage);
		return savedMessage;
	}
}
