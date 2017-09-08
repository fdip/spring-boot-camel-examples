package com.pionieerlabs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.pionieerlabs.app.config.MessageProperties;
import io.hawt.springboot.EnableHawtio;
import io.hawt.web.AuthenticationFilter;

@EnableHawtio
@EnableHystrixDashboard
@SpringBootApplication
@EnableConfigurationProperties({MessageProperties.class})
public class PollerServiceApplication {

	public static void main(String[] args) {
		// FIXME: Only for demo purpose, don't do this in production env
		System.setProperty(AuthenticationFilter.HAWTIO_AUTHENTICATION_ENABLED, "false");

		SpringApplication.run(PollerServiceApplication.class, args);
	}
}
