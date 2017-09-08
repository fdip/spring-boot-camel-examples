package com.pionieerlabs.app.messages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.pionieerlabs.app.ConsumerServiceApplicationTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MessageServiceTest  {

	@Autowired
	MessageService messageService;

	@Test
	@Sql("/message-two-rows.sql")
	public void shouldFind2Elemetns() throws Exception {

		// Given two rows in messages table

		// When
		List<Message> all = messageService.findAll();
		// Then
		assertThat(all.size()).isEqualTo(2);
	}

	@Test
	public void shouldReturnEmptyListWhenNoMessagesInDatabase() throws Exception {

		// Given empty messages table

		// When
		List<Message> all = messageService.findAll();
		// Then
		assertThat(all.isEmpty());
	}

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