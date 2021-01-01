package com.xhc.springcode.aspect.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo1 {

	@Test
	public void run1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext4.xml");
		CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
		customerDao.save1();
	}
}
