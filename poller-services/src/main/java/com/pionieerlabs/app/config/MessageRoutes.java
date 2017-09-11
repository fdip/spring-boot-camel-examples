package com.pionieerlabs.app.config;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.HystrixConfigurationDefinition;

@AllArgsConstructor
@Component
public class MessageRoutes extends RouteBuilder {
	private final MessageProperties properties;

	@Override
	public void configure() throws Exception {
		HystrixConfigurationDefinition hystrixConfigurationDefinition = getHystrixConfigurationDefinition();

		from("timer://message?period=" + properties.getPollingPeriod())
			.id("messages-timer")
			.hystrix().hystrixConfiguration(hystrixConfigurationDefinition)
				.id("get-random-message")
				.setHeader(Exchange.HTTP_METHOD, simple("GET"))
				.to(properties.getGeneratorServiceUrl() + "/messages/generate")
				.log("Polling")
            .onFallback()
                .log("generator-service not available")
            .end()
            .hystrix().hystrixConfiguration(hystrixConfigurationDefinition)
				.id("post-message")
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.to(properties.getConsumerServiceUrl() + "/messages")
            .onFallback()
                .log("consumer-service not available")
	        .end();
	}

	private HystrixConfigurationDefinition getHystrixConfigurationDefinition() {
		HystrixConfigurationDefinition hystrixConfigurationDefinition = new HystrixConfigurationDefinition();
		hystrixConfigurationDefinition.setCorePoolSize(properties.getHystrixCorePoolSize());
		hystrixConfigurationDefinition.groupKey(properties.getHystrixGroupKey());
		hystrixConfigurationDefinition.threadPoolKey(properties.getHystrixThreadPoolKey());
		return hystrixConfigurationDefinition;
	}
}
