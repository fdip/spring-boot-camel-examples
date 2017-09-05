package com.pioneerlabs.app.messages;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageService {

	public void process(Message message) {
		log.info("Received message: {}", message);
	}
}
