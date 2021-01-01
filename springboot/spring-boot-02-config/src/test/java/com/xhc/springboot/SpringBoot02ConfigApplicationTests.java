package com.xhc.springboot;

import com.xhc.springboot.bean.Emp;

import com.xhc.springboot.config.EmpConfig;
import com.xhc.springboot.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

    @Autowired
    Emp emp;


    @Test
    public void testXml() {

//       ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring01.xml");
//        EmpService empService = (EmpService) ctx.getBean("empService");
//        System.out.println(empService);

        ApplicationContext ctx1=new AnnotationConfigApplicationContext(EmpConfig.class);
        EmpService empService = (EmpService) ctx1.getBean("empService2");
        System.out.println(empService);

        System.out.println(emp);

////        empService.add();
        //EmpService empService2 = (EmpService)context.getBean("empService2");
       // System.out.println("empService2: " + empService2);
    }

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }

}
