package com.xhc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot02Config02Application {

    public static void main(String[] args) {
        //返回module的路径 D:\SpringBootProject\spring-boot-01-hello
        // 正确： D:\SpringBootProject\spring-boot-02-config-02
        System.out.println( System.getProperty("user.dir") );
        SpringApplication.run(SpringBoot02Config02Application.class, args);
    }
}
