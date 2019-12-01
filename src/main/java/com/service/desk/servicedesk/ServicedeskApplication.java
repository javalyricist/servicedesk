package com.service.desk.servicedesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.service.desk.servicedesk")
@EnableJpaRepositories("com.service.desk.servicedesk.repository") 
@EntityScan("com.service.desk.servicedesk.entity") 
public class ServicedeskApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ServicedeskApplication.class, args);

	}
}
