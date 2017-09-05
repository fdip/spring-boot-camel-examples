package com.pionieerlabs.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;

@Getter
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class CamelProperties {
	private String generatorServiceUrl;
	private String consumerServiceUrl;
	private int pollingPeriod = 1000;
}
