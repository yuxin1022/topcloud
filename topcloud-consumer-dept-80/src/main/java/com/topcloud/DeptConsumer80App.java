package com.topcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.rule.MyRandomRule;

@SpringBootApplication
@EnableEurekaClient
//在微服务启动时候加入我们的自定义Ribbon配置
@RibbonClient(name="TOPCLOUD-DEPT",configuration=MyRandomRule.class)
public class DeptConsumer80App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80App.class, args);
	}

}
