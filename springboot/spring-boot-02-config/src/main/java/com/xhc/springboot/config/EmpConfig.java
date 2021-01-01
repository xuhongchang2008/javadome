package com.xhc.springboot.config;

import com.xhc.springboot.bean.Emp;
import com.xhc.springboot.service.EmpService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 它是spring里的注解，用于标识当前类是一个配置类，来表示对应spirng配置文件
 * @Title: EmpConfig
 * @Description: com.xhc.springboot.config
 * @Auther: www.xhc.com
 * @Version: 1.0
 */
@EnableConfigurationProperties(Emp.class)
@Configuration
public class EmpConfig {

    /**
     * @Bean 标识的方法用于向容器中注入组件
     * 1. 返回值就是注入容器中的组件对象
     * 2. 方法名就是这个组件的 id 值
     * @return
     */
    @Bean
    public EmpService empService2() {
        System.out.println(" EmpService 组件注入成功");
        return new EmpService();
    }

}
