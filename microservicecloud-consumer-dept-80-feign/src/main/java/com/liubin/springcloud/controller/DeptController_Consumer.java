package com.liubin.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liubin.springcloud.entities.Dept;
import com.liubin.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;
	
	@RequestMapping(value="/consumer/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		
		return service.add(dept);
	}
	@RequestMapping(value="/consumer/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") long id){
		
		return service.get(id);
	}	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		
		return service.list();
	}	
	
}
