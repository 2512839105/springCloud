package com.liubin.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liubin.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

 

@Component//此注解一定要加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDname("该Id: "+id+"----没有查到对应的信息").setDb_source("该Id: "+id+"----没有查到对应的信息,Consumer客户端提供的降级信息，此刻服务Provider已经关闭").setDb_source("no this database in MYSLQ");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
