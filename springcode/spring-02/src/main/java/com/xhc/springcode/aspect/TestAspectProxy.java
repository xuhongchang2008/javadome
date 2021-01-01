package com.xhc.springcode.aspect;

import com.xhc.springcode.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectProxy {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("UserServiceImpl");

        //userService.login("suns", "root");

        userService.register(new User());
    }
}
