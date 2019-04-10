package com.topcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.topcloud.pojo.Dept;

@RestController
public class DeptController_Consumer {
	
	//private static final String REST_URL_PREFIX = "HTTP://localhost:8001";
	private static final String REST_URL_PREFIX = "HTTP://TOPCLOUD-DEPT";

	@Autowired	
	private RestTemplate restTemplate;
	
	//url，requestMap，ResponseBean.class 分别是 REST请求地址、请求参数、HTTP想要转换被转换成对象的类型
	@RequestMapping(value="consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept,Boolean.class);
	}
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return  restTemplate.getForObject( REST_URL_PREFIX+"/dept/findById/"+id,Dept.class);
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
	
	@RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
	
}
