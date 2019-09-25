package com.trilogyed.DelcieDionmagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DelcieDionMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelcieDionMagicEightBallServiceApplication.class, args);
	}

}
