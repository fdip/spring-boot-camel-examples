package com.pionieerlabs.app.messages;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/messages")
@AllArgsConstructor
public class MessageController {
	private final MessageService messageService;

	@PostMapping
	ResponseEntity<Message> save(@RequestBody Message message) {
		return ResponseEntity.ok(messageService.save(message));
	}
}
