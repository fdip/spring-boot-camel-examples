package com.pionieerlabs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.pionieerlabs.app.config.CamelProperties;

@SpringBootApplication
@EnableConfigurationProperties({CamelProperties.class})
public class PollerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollerServiceApplication.class, args);
	}
}
