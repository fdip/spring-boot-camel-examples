package com.pionieerlabs.app.config;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

@AllArgsConstructor
@Component
public class MessageRoutes extends RouteBuilder {
	private final MessageProperties properties;

	@Override
	public void configure() throws Exception {
		from("timer://message?period=" + properties.getPollingPeriod())
			.setHeader(Exchange.HTTP_METHOD, simple("GET"))
			.to(properties.getGeneratorServiceUrl() + "/messages/generate")
			.log("Polling")
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))
			.to(properties.getConsumerServiceUrl() + "/messages");
	}
}
