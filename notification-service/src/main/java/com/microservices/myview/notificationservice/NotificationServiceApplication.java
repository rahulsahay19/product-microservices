package com.microservices.myview.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	//Spring cloud stream
	//This will receive message from rabbitmq and then call the service email sender to send the confirmation
	@Bean
	public Consumer<String> notificationEvenSupplier(){
		return message ->{
			new EmailSender().sendEmail(message);
		};
	}
}
