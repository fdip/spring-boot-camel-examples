package com.pioneerlabs.app.messages;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
	private final MessageRepository messageRepository;

	public Message save(Message message) {
		Message savedMessage = messageRepository.save(message);
		log.info("Received message: {}", savedMessage);
		return savedMessage;
	}
}
