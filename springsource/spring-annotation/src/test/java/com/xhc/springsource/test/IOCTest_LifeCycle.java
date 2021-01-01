package com.xhc.springsource.test;

import com.xhc.springsource.bean.white;
import com.xhc.springsource.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {
	
	@Test
	public void test01(){
		//1、创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("=====================> 容器创建完成...");

		white white1 = (white) applicationContext.getBean("white");
		white1.setY(2);
		System.out.println ("=====================> getY..."+white1.getY());
		System.out.println ("=====================> getSs..."+white1.getSs());

//		applicationContext.getBean("car");
		//关闭容器
		applicationContext.close();
	}
}
