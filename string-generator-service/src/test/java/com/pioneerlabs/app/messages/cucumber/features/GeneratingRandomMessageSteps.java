package com.pioneerlabs.app.messages.cucumber.features;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.pioneerlabs.app.messages.cucumber.StepsDefinition;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@StepsDefinition
public class GeneratingRandomMessageSteps {
	private ResultActions result;

	@Autowired
	private MockMvc mockMvc;

	@When("^user try to get new message$")
	public void userTryToGetNewMessage() throws Throwable {
		result = mockMvc.perform(get("/api/messages")
		                        .contentType(MediaType.APPLICATION_JSON));
	}

	@Then("^I should generate random valid message")
	public void iShouldGenerateRandomValidResponse() throws Throwable {
		result.andExpect(status().isOk())
	          .andExpect(jsonPath("id", is(not(nullValue()))))
	          .andExpect(jsonPath("content", is(not(nullValue()))));
	}
}
