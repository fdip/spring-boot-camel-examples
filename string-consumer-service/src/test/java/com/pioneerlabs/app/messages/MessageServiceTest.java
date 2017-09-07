package com.pioneerlabs.app.messages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = NONE)
public class MessageServiceTest {
	@Autowired
	private MessageService messageService;

	@Test
	public void shouldProcessValidMessage() throws Exception {
		// Given
		Message message = new Message(1L, "content");

		// When
		Message processedMsg = messageService.save(message);

		// Then
		assertThat(processedMsg.getId()).isEqualTo(1L);
		assertThat(processedMsg.getContent()).isEqualTo("content");
	}

}