package com.xhc.springcode.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.xhc.springcode.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
