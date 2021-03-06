package com.topcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	//Eureka服务启动类
public class EurekaServer7003APP {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003APP.class, args);
	}
}
