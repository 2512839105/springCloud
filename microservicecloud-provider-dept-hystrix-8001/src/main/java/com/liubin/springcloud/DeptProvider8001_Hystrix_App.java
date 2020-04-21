package com.liubin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableCircuitBreaker//对hystrixR熔断器机制的支持
@EnableDiscoveryClient//服务发现
@SpringBootApplication
@EnableEurekaClient //开启本服务启动后会自动注册进eureka 服务中
public class DeptProvider8001_Hystrix_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
	}
	
}

