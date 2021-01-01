package com.xhc.springsource.ext.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
//定义事件源
public class MailSender {
    @Autowired
    private ApplicationContext applicationContext;  //容器事件由容器触发

    public void sendMail(String to){
        System.out.println("MailSender开始发送邮件");
        MailSendEvent event = new MailSendEvent(applicationContext,to);
        applicationContext.publishEvent(event);
    }
}