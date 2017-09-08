package com.pionieerlabs.app.config.routes;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "app.camel.routes.message", ignoreUnknownFields = false)
public class MessageRouteProperties {
	private String cronTrigger = "0/15 * * * * ?";
	private Ftp ftp = new Ftp();

	@Getter
	@Setter
	public static class Ftp {
		private String protocol = "sftp";
		private String username;
		private String password;
		private String host = "localhost";
		private int port = 21;
	}
}
