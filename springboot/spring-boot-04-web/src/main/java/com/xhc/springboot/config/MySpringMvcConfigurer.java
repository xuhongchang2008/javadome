package com.xhc.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1. @Configuration class of type WebMvcConfigurer but without @EnableWebMvc
 * 1. 创建一个WebMvcConfigurer类型的子类
 * 2. 类上用@Configuration标识它是一个配置类
 * 3. 不能@EnableWebMvc标识
 * 原理：
 *  1.导入@Import({WebMvcAutoConfiguration.EnableWebMvcConfiguration.class})
 *  2.  public static class EnableWebMvcConfiguration extends DelegatingWebMvcConfiguration {
 *
 *
 * @Auther: xhc
 */
//完全掌握springmvc
@EnableWebMvc
@Configuration
public class MySpringMvcConfigurer implements WebMvcConfigurer {

    //增加视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //发送 /xhc请求 会来到 success.html
        registry.addViewController("/xhc").setViewName("success");
    }


}
