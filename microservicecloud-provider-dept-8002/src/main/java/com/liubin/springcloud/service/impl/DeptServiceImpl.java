package com.liubin.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liubin.springcloud.dao.DeptDao;
import com.liubin.springcloud.entities.Dept;
import com.liubin.springcloud.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return dao.addDept(dept);
	}

	@Override
	public Dept get(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
