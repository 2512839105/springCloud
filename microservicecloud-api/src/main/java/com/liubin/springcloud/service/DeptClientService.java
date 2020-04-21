package com.liubin.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.liubin.springcloud.entities.Dept;

//@FeignClient(value="MICROSERVICECLOUD-DEPT") Feign 添加注解
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
//服务降级添加内容fallbackFactory=DeptClientServiceFallbackFactory.class
public interface DeptClientService {
	@RequestMapping(value="/dept/add",method=RequestMethod.GET)
	public boolean add(Dept dept);
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);
	
	@RequestMapping(value="/dept/list",method=RequestMethod.POST)
	public List<Dept> list();
}
