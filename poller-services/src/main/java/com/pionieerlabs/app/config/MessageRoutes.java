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
			.hystrix()
				.setHeader(Exchange.HTTP_METHOD, simple("GET"))
				.to(properties.getGeneratorServiceUrl() + "/messages/generate")
				.log("Polling")
            .onFallback()
                .log("generator-service not available")
            .end()
            .hystrix()
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.to(properties.getConsumerServiceUrl() + "/messages")
            .onFallback()
                .log("consumer-service not available")
	        .end();
	}
}
