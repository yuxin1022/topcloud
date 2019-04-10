package com.topcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.topcloud.pojo.Dept;

@Mapper
public interface DeptDao {
	
	public boolean addDept(Dept dept);
	
	public Dept findById(Long deptNo);
	
	public List<Dept> findAll();

}
