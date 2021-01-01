package com.xhc.springsource.ext.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventTest {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TestExtConfig.class);
        MailSender sender  = (MailSender)context.getBean("mailSender");
        sender.sendMail("北京");
    }
}
