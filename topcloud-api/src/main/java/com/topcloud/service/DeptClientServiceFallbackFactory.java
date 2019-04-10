package com.topcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.topcloud.pojo.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory  implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			  @Override
	            public boolean add(Dept dept) {
	                return false;
	            }

			  	@Override
	            public Dept findById(Long id) {
			  		Dept dept = new Dept();
			  		dept.setDeptNo(id);
			  		dept.setDeptName("no such data please waiting");
	                return dept;
	            }

	            @Override
	            public List<Dept> findAll() {
	                List<Dept> list=new ArrayList<Dept>();
	                Dept dept = new Dept();
	                dept.setDeptName("no list");
	                list.add(dept);
	                return list;
	            }
	       };
	};
}