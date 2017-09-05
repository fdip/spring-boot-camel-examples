package com.pioneerlabs.app.messages;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/messages")
@AllArgsConstructor
public class MessageController {
	private final MessageService messageService;

	@PostMapping
	ResponseEntity logMessage(@RequestBody Message message) {
		messageService.process(message);
		return ResponseEntity.ok(message);
	}
}
