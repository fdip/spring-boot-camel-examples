package com.pionieerlabs.app.config.routes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.pionieerlabs.app.messages.MessageService;
import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

@Component
@AllArgsConstructor
public class MessageRoutes extends RouteBuilder {
	private final MessageService messageService;
	private final MessageRouteProperties routeProperties;

	@Override
	public void configure() throws Exception {

		from("timer://message?period=" + routeProperties.getPollingPeriod())
			.setHeader(Exchange.HTTP_METHOD, simple("GET"))
			.to(routeProperties.getGeneratorServiceUrl() + "/messages")
			.log("Polling")
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))
			.to(routeProperties.getConsumerServiceUrl() + "/messages");

		from("quartz2://jobTimer?cron=" + routeProperties.getCronTrigger())
			.bean(messageService, "findAll")
			.log("Processed message ${body.size}");
			//.marshal()
			//.json(JsonLibrary.Jackson)
			//.setHeader("CamelFileName", generateFileName())
			//.to(buildFtpUri());


	}

	private String buildFtpUri() {
		MessageRouteProperties.Ftp ftp = routeProperties.getFtp();
		return String.format("ftp://%s@%s:%s/?password=%s&disconnect=true", ftp.getUsername(), ftp.getHost(), ftp.getPort(), ftp.getPassword());
	}

	private Supplier<Object> generateFileName() {
		return () -> String.format("messages-%s.json", LocalDateTime.now()
																	.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
	}
}
