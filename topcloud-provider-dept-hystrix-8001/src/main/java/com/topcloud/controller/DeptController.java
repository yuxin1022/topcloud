package com.topcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.topcloud.pojo.Dept;
import com.topcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/dept/add",method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	  @RequestMapping(value = "/dept/{id}",method = RequestMethod.GET)
	    @HystrixCommand(fallbackMethod = "processHystrix_Get")
	    public Dept getDept(@PathVariable("id") Long id){
	        Dept dept= service.get(id);
	        if(null == dept){
	            throw  new RuntimeException("sorry"+ id+"can not find your data");
	        }
	        return dept;
	    }
	    public  Dept processHystrix_Get(@PathVariable("id") Long id){
			return null;
			//return new Dept().setDeptno(id).setDname("wow"+"没有对应信息");
	    }
    
	@RequestMapping(value="/dept/list",method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}
	
	/**
	 * 	增加自己服务描述的接口
     * @return
     */
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务"+list.size());

        //查询STUDY-SPRINGCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");

        //打印STUDY-SPRINGCLOUD-DEPT服务信息
        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;
    }

}
