package com.xhc.springsource.config;

import com.xhc.springsource.beanperiod.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PeriodConfig {

    @Bean(initMethod = "myInit",destroyMethod = "myDestory")
    public PersonPer PersonPer() {
        System.out.println("=========================================");
        System.out.println("给容器中添加PersonPer....");
        System.out.println("=========================================");
        return new PersonPer();
    }

    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public MyBeanDefinitionRegistryPostProcessor MyBeanDefinitionRegistryPostProcessor() {

        System.out.println("=========================================");
        System.out.println("给容器中添加MyBeanDefinitionRegistryPostProcessor....");
        System.out.println("=========================================");
        return new MyBeanDefinitionRegistryPostProcessor();
    }


    @Bean
    public MyBeanFactoryPostProcessor MyBeanFactoryPostProcessor() {

        System.out.println("=========================================");
        System.out.println("给容器中添加MyBeanFactoryPostProcessor....");
        System.out.println("=========================================");
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor MyBeanPostProcessor() {
        System.out.println("=========================================");
        System.out.println("给容器中添加MyBeanPostProcessor....");
        System.out.println("=========================================");
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor MyInstantiationAwareBeanPostProcessor() {
        System.out.println("给容器中添加MyInstantiationAwareBeanPostProcessor....");
        return new MyInstantiationAwareBeanPostProcessor();
    }






}
