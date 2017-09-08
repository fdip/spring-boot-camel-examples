package com.pionieerlabs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.pionieerlabs.app.config.MessageProperties;

@EnableHystrixDashboard
@SpringBootApplication
@EnableConfigurationProperties({MessageProperties.class})
public class PollerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollerServiceApplication.class, args);
	}
}
