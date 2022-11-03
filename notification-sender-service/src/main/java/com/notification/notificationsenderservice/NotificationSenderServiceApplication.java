package com.notification.notificationsenderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NotificationSenderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSenderServiceApplication.class, args);
	}

}
