package com.xhc.springsource.ext.test;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
//该事件的监听器MailSendListener
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        MailSendEvent event = mailSendEvent;
        System.out.println("使用ApplicationListener类，在MailSendListener监听器中，MailSender向"+ event.getTo()+ "发送了邮件");
    }
}