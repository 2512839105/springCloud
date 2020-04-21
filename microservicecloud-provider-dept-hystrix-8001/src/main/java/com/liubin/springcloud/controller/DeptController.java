package com.liubin.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.liubin.springcloud.entities.Dept;
import com.liubin.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;
 
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") long id){
	    Dept dept=service.get(id);
		if(null==dept){
			throw new RuntimeException("该Id:"+id+"没有对应的信息");
		}
		return dept;
	}	
	
	
	public Dept processHystrix_Get(@PathVariable("id") long id){
		
		return new Dept().setDname("该Id: "+id+"----没有查到对应的信息").setDb_source("该Id: "+id+"----没有查到对应的信息no this datavase in MySQL");
	}

}
