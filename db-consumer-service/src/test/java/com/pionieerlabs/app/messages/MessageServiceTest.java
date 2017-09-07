package com.pionieerlabs.app.messages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.pionieerlabs.app.DbServiceApplicationTest;
import org.junit.Test;

public class MessageServiceTest extends DbServiceApplicationTest {

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

}