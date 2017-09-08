package com.pionieerlabs.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "pioneerlabs", ignoreUnknownFields = false)
public class MessageProperties {
	private String generatorServiceUrl;
	private String consumerServiceUrl;
	private int pollingPeriod = 1000;
}
