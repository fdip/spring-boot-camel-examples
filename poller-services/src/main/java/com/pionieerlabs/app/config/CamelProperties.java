package com.pionieerlabs.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "camel", ignoreUnknownFields = false)
public class CamelProperties {
	private String generatorServiceUrl;
	private String consumerServiceUrl;
	private int pollingPeriod = 1000;
}
