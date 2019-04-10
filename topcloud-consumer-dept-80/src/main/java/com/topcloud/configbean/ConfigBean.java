package com.topcloud.configbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//Spring boot ---> spring  applicationContext.xml ---> @Configuration
	
	@Bean
	@LoadBalanced	//SpirngCloud Ribbon实现客户端负载
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*@Bean
	public IRule myRule() {
		return new RandomRule();//选择随机算法(默认轮询)
	}*/

}
