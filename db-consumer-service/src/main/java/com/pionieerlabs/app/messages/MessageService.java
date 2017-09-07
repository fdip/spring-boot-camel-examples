package com.pionieerlabs.app.messages;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MessageService {
	private final MessageRepository messageRepository;

	public List<Message> findAll() {
		return messageRepository.findAll();
	}
}
