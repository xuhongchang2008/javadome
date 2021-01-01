package com.xhc.springsource.ext.test;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MailSendEventListener {

    @EventListener
    public void listenMailSend(MailSendEvent mailSendEvent) {

        MailSendEvent event = mailSendEvent;
        System.out.println("使用@EventListener，在MailSendEventListener监听器中，MailSender向"+ event.getTo()+ "发送了邮件");
    }

}
