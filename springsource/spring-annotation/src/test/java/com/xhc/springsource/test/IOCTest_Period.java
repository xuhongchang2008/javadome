package com.xhc.springsource.test;
import com.xhc.springsource.beanperiod.PersonPer;
import com.xhc.springsource.config.PeriodConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Period {

    @Test
    public void test1()
    {
        System.out.println("===================================初始化容器开始=======================================");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PeriodConfig.class);

        System.out.println("   ");
        System.out.println("打印容器中的Bean==============================开始");
        printBeans(applicationContext);
        System.out.println("打印容器中的Bean==============================结束");
        System.out.println("   ");

        System.out.println("   ");
        System.out.println("===================getBean开始=================");
        PersonPer personPer = applicationContext.getBean(PersonPer.class);
        personPer.setName("张三");
        personPer.setPhone(131);
        System.out.println("                 PersonPer="+personPer.toString());
        System.out.println("===================getBean结束=================");
        System.out.println("   ");

//        PersonLink personLink = applicationContext.getBean(PersonLink.class);
//        System.out.println("PersonLink="+personLink.toString());
        System.out.println("===================================初始化容器结束=======================================");
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        //获取的是 Spring⼯⼚配置⽂件中所有bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        int i=1;
        for (String name : definitionNames) {
            System.out.println("---->第"+i+"个Bean,名称="+name);
            i++;
        }

        //根据类型获得Spring配置⽂件中对应的id值
        String[] beanNamesForType = applicationContext.getBeanNamesForType(PersonPer.class);
        for (String id : beanNamesForType) {
            System.out.println("PersonPer = " + id);
        }

        //⽤于判断是否存在指定id值得bean
        if (applicationContext.containsBean("PersonPer")) {
            System.out.println("true = " + true);
        }else{
            System.out.println("false = " + false);
        }
    }
}
