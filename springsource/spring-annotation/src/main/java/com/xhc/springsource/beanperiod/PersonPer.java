package com.xhc.springsource.beanperiod;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class PersonPer implements BeanFactoryAware, BeanNameAware, ApplicationContextAware, EnvironmentAware, EmbeddedValueResolverAware, InitializingBean, DisposableBean
    {
        private String name;
        private String address;
        private int phone;

        private BeanFactory beanFactory;
        private String beanName;
        private ApplicationContext applicationContext;

            public PersonPer() {
            System.out.println("=========================================");
            System.out.println("PersonPer 初始化...");
            System.out.println("=========================================");
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            System.out.println("                 【注入属性】注入属性name="+name);
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            System.out.println("                 【注入属性】注入属性address="+address);
            this.address = address;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            System.out.println("                 【注入属性】注入属性phone="+phone);
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Person [address=" + address + ", name=" + name + ", phone=" + phone + "]";
        }

        // 这是BeanFactoryAware接口方法
        @Override
        public void setBeanFactory(BeanFactory beanfactory) throws BeansException {
            System.out.println("                 【BeanFactoryAware接口】.setBeanFactory()===>>BeanFactory="+beanfactory.toString());
            this.beanFactory = beanfactory;
        }

        // 这是BeanNameAware接口方法
        @Override
        public void setBeanName(String beanname) {
            System.out.println("                 【BeanNameAware接口】.setBeanName()===>>BeanName="+beanname);
            this.beanName = beanname;
        }

        //这是ApplicationContextAware
        @Override
        public void setApplicationContext(ApplicationContext applicationcontext) throws BeansException {

            System.out.println("                 【ApplicationContextAware接口】.setApplicationContext()===>>ApplicationContext="+applicationcontext);
            this.applicationContext = applicationcontext;
        }

        //这是EmbeddedValueResolverAware
        @Override
        public void setEmbeddedValueResolver(StringValueResolver resolver) {
            // TODO Auto-generated method stub
            String resolveStringValue = resolver.resolveStringValue("幸运数字 #{999*999}");
            System.out.println("                 【EmbeddedValueResolverAware接口】.setEmbeddedValueResolver()===>>StringValueResolver="+resolveStringValue);

        }


        //这是EnvironmentAware
        @Override
        public void setEnvironment(Environment environment) {
            String[] str=  environment.getDefaultProfiles();

            System.out.println("                 【EnvironmentAware接口】EnvironmentAware接口.setEnvironment()===>>environment="+str.toString());

        }

        // 这是InitializingBean接口方法
        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("                 2、【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
        }

        // 这是DiposibleBean接口方法
        @Override
        public void destroy() throws Exception {
            System.out.println("                 2、【DiposibleBean接口】调用DiposibleBean.destory()");
        }

        //对象创建并赋值之后调用
        @PostConstruct
        public void initPostConstruct(){
            System.out.println("                 1、【初始化方法：@PostConstruct】");
        }

        //容器移除对象之前
        @PreDestroy
        public void detoryPreDestroy(){
            System.out.println("======================================容器销毁==========================================");
            System.out.println("                 1、【执行方法：@PreDestroy】");
        }


        // 通过<bean>的init-method属性指定的初始化方法
        public void myInit() {

            System.out.println("                 3、【init-method】调用<bean>的init-method属性指定的初始化方法");
        }

        // 通过<bean>的destroy-method属性指定的初始化方法
        public void myDestory() {
            System.out.println("                 3、【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
        }
}
