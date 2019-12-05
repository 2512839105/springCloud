package com.liubin.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
 @SuppressWarnings("serial")
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
 @Accessors(chain=true)
public class Dept implements Serializable {
	private Integer deptno;//主键
	private String dname;//部门名称
	private String db_source;//来自哪个数据库，因为为服务架构可以一个服务对应一个数据库，同一个信息被储存到不同的数据库
 
	
	public static void main(String[] args) {
		Dept dept=new Dept();
		dept.setDeptno(1);
		 
				
	}
}
