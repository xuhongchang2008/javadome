package com.xhc.springsource.beanperiod;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationAwareBeanPostProcessor() {
        System.out.println("====================================================================");
        System.out.println("实例化InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
        System.out.println("====================================================================");
    }

    // 接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if(beanName.equals("PersonPer")||beanName.equals("PersonLink")) {

            System.out.println("~~~~【InstantiationAwareBeanPostProcessorAdapter接口】.postProcessBeforeInstantiation()===>>{前置}===" +
                    beanClass.getName());
        }
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("PersonPer")||beanName.equals("PersonLink")) {

            System.out.println("~~~~【InstantiationAwareBeanPostProcessorAdapter接口】.postProcessAfterInitialization()===>>{后置}===" + bean);
        }
        return bean;
    }
//
    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if(beanName.equals("PersonPer")||beanName.equals("PersonLink")) {

            System.out.println("                 【InstantiationAwareBeanPostProcessorAdapter接口】.postProcessPropertyValues()===>>{取值}===" + bean.toString() + "+===>>pvs=" + pvs.getPropertyValue("address").getValue().toString());
        }
        return pvs;
    }
}
