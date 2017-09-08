package com.pionieerlabs.app.cucumber.features;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pionieerlabs.app.cucumber.StepsDefinition;
import com.pionieerlabs.app.messages.Message;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@StepsDefinition
public class PostingNewMessageSteps {
	private Message newMessage;
	private ResultActions result;

	@Autowired
	private MockMvc mockMvc;

	@Given("^message with (.+)$")
	public void messageWithContent(String content) throws Throwable {
		newMessage = new Message(1L, content);
	}

	@When("^user try to save message$")
	public void userTryToSaveMessage() throws Throwable {
		result = mockMvc.perform(post("/api/messages")
									 .contentType(MediaType.APPLICATION_JSON_UTF8)
									 .content(new ObjectMapper().writeValueAsBytes(newMessage))
								);
	}

	@Then("^I should see valid (.+)$")
	public void iShouldSeeValidResponse(String response) throws Throwable {
		result.andExpect(status().isOk())
			  .andExpect(jsonPath("id", is(not(nullValue()))))
			  .andExpect(jsonPath("content", is(equalTo(response))));
	}
}
