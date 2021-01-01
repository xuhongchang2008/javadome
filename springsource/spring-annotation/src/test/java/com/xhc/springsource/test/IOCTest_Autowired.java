package com.xhc.springsource.test;

import com.xhc.springsource.config.MainConifgOfAutowired;
import com.xhc.springsource.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);

//		BookController bookController = applicationContext.getBean(BookController.class);
//		System.out.println(bookController);

		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);

//		BookDao bookDao = (BookDao) applicationContext.getBean("bookDao0");
//		System.out.println(bookDao);

//		Boss boss = applicationContext.getBean(Boss.class);
//		System.out.println(boss);
//
//		Car car = applicationContext.getBean(Car.class);
//		System.out.println(car);
//
//		Color color = applicationContext.getBean(Color.class);
//		System.out.println(color);

		System.out.println(applicationContext);
		applicationContext.close();
	}

}
