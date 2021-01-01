package com.xhc.springcode.aspect.xml;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 测试AOP功能
 * @author Administrator
 */

public class Demo3 {
	

	
	@Test
	public void run1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext3.xml");
		CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
		customerDao.save();
//		// customerDao.update();
	}
}














