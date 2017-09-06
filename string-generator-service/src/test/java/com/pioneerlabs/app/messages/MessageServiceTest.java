package com.pioneerlabs.app.messages;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

	@Autowired
	private MessageService messageService;


	@Test
	public void shouldGenerateRandomMessage() throws Exception {

		// When
		Message message = messageService.generateRandom();
		// Then
		assertThat(message.getId()).isEqualTo(1L);
		assertThat(message.getContent()).isNotEmpty();
	}
}