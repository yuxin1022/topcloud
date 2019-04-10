package com.topcloud.service;

import java.util.List;

import com.topcloud.pojo.Dept;

public interface DeptService {
	
	public boolean add(Dept dept);
	
	public Dept get(Long deptNo);
	
	public List<Dept> list();

}
