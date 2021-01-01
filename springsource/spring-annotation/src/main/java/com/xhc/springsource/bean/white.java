package com.xhc.springsource.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//        ---->white constructor...并赋值+1
//        当前bean的名字white
//        当前环境：[Ljava.lang.String;@5762806e
//        解析的字符串：你好 Windows 10 我是 121
//        传入的ioc：org.springframework.context.annotation.AnnotationConfigApplicationContext@57fa26b7:
//        postProcessBeforeInitialization...white=>com.xhc.springsource.bean.white@6ef888f6
//        ---->white....@PostConstruct...
//        ---->white ... afterPropertiesSet...
//        ---->white ... beaninit...
//        postProcessAfterInitialization...white=>com.xhc.springsource.bean.white@6ef888f6
//        =====================> 容器创建完成...
//        =====================> getY...2
//        ---->white....@PreDestroy...
//        ---->white ... DisposableBean...
//        ---->white ... beandetory...


//@Component
public class white implements InitializingBean, DisposableBean,ApplicationContextAware, BeanNameAware, EnvironmentAware, EmbeddedValueResolverAware, BeanFactoryPostProcessor
{


    public white(int x)
    {
        this.x=x;
        System.out.println("---->white constructor...并赋值+"+this.x);
    }

    public white()
    {

    }


    private int x=0;

    private int z=3;

    private int y;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    private  String ss;
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }





    private String beanname;



    public void init() {
        System.out.println("---->white ... beaninit...");
    }

    public void detory() {
        System.out.println("---->white ... beandetory...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---->white ... DisposableBean...");
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---->white ... afterPropertiesSet...");

    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init1(){
        System.out.println("---->white....@PostConstruct...");
    }

    //容器移除对象之前
    @PreDestroy
    public void detory1(){
        System.out.println("---->white....@PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("传入的ioc：" + applicationContext);
    }

    @Override
    public void setBeanName(String name) {
        // TODO Auto-generated method stub
        this.beanname=name;
        System.out.println("当前bean的名字" + name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        // TODO Auto-generated method stub
        String resolveStringValue = resolver.resolveStringValue("你好 ${os.name} 我是 #{11*11}");
        System.out.println("解析的字符串：" + resolveStringValue);
    }


    @Override
    public void setEnvironment(Environment environment) {
        String[] str=  environment.getDefaultProfiles();

        System.out.println("当前环境：" + str.toString());
    }



    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition beanDefinition = getGenericBeanDefinition();

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("white", beanDefinition);
        System.out.println("赋值ss属性：--------------------------------" + this.getSs());
    }
    private GenericBeanDefinition getGenericBeanDefinition() {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(white.class);
        beanDefinition.getPropertyValues().add("ss", "abcdddd");
        return beanDefinition;
    }


}
