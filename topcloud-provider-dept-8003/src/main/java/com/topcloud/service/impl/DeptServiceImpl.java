package com.topcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topcloud.dao.DeptDao;
import com.topcloud.pojo.Dept;
import com.topcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao dao;

	@Override
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long deptNo) {
		return dao.findById(deptNo);
	}

	@Override
	public List<Dept> list() {
		return dao.findAll();
	}

}
