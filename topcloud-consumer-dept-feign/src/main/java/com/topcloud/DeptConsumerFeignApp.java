package com.topcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.topcloud"})
@ComponentScan("com.topcloud")
public class DeptConsumerFeignApp {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeignApp.class, args);
	}

}
