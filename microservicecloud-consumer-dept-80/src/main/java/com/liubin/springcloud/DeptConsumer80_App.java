package com.liubin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.liubin.myrule.MyselfRule;
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MyselfRule.class)//在启动微服务的时候加载我们自定义的ribon配置类，其中定义了负载均衡的策略
public class DeptConsumer80_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptConsumer80_App.class,args);
	}
}
