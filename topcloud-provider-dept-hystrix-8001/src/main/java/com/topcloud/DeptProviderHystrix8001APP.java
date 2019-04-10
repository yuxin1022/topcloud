package com.topcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient	//本服务启动后自动加入（注册到）eureka服务中
@EnableDiscoveryClient	//服务发现
@EnableCircuitBreaker	//对hystrix熔断器支持
public class DeptProviderHystrix8001APP {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptProviderHystrix8001APP.class, args);
	}

}
