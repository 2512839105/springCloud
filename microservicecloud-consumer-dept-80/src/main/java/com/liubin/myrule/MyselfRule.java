package com.liubin.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MyselfRule {

	@Bean
	public IRule myRule(){
		//return new RoundRobinRule();//轮询
		return new RandomRule_ZY();//自定义负载均衡算法 每台机器请求5次数

	}
}
