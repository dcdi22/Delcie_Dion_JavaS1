package com.company.delciedioncloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DelcieDionCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelcieDionCloudConfigServerApplication.class, args);
	}

}
