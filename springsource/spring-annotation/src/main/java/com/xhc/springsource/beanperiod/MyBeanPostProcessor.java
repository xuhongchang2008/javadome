package com.xhc.springsource.beanperiod;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("====================================================================");
        System.out.println("实例化BeanPostProcessor实现类构造器！！");
        System.out.println("====================================================================");
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        if(beanName.equals("PersonPer")||beanName.equals("PersonLink")) {

            System.out.println("~~~~~~~~【BeanPostProcessor接口】.postProcessAfterInitialization()===>>{后置}===" + bean.toString());
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if(beanName.equals("PersonPer")||beanName.equals("PersonLink"))
         {
                System.out.println("~~~~~~~~【BeanPostProcessor接口】.postProcessBeforeInitialization===>>{前置}===" + bean.toString());
            }
        return bean;
    }
}
