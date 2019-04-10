package com.topcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcloud.pojo.Dept;
import com.topcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;
	
	@RequestMapping(value="consumer/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping(value = "/consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo){
        return  service.findById(deptNo);
    }
	
	@RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return  service.findAll();
    }
	
	
}
