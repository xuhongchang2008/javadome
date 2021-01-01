package com.xhc.springsource.beanperiod;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;



public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("====================================================================");
        System.out.println("实例化BeanFactoryPostProcessor实现类构造器！！");
        System.out.println("====================================================================");
    }


    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //GenericBeanDefinition PersonLinkDefinition = GetPersonLinkDefinition();
       // ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("PersonLink", PersonLinkDefinition);

        GenericBeanDefinition PersonPerDefinition = GetPersonPeriodDefinition();

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("PersonPer", PersonPerDefinition);
        System.out.println("【BeanFactoryPostProcessor接口】.postProcessBeanFactory()===" + beanFactory.toString());
//        PersonPer personPer=beanFactory.getBean(PersonPer.class);
//
//        System.out.println("【BeanFactoryPostProcessor】.postProcessBeanFactory()===" + personPer);

        //这种方法尽量不要用，这里获取Bean的时候会把对象对实例化掉，正常来说这里只是bean的定义信息
        //https://www.jianshu.com/p/3d099ea43b0e
        //Blue bule_01 = beanFactory.getBean("bule_01", Blue.class);
        //InitializingBean
//        BeanDefinition bule_01 = beanFactory.getBeanDefinition("bule_01");
//        bule_01.getPropertyValues().add("name", "哈哈哼哼");
//        bule_01.setScope(BeanDefinition.SCOPE_SINGLETON);
        // bule_01.setInitMethodName();
        System.out.println("BeanFactoryPostProcessor的postProcessBeanFactory方法正在调用...");



    }
//    private GenericBeanDefinition GetPersonLinkDefinition() {
//        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.setBeanClass(PersonLink.class);
//        beanDefinition.getPropertyValues().add("likename", "李四");
//        return beanDefinition;
//    }


    private GenericBeanDefinition GetPersonPeriodDefinition() {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(PersonPer.class);
        beanDefinition.getPropertyValues().add("address", "北京");
        System.out.println("修改PersonPer对象的Bean的定义，注入属性其中的address=北京");

        return beanDefinition;
    }


}
