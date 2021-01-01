package com.xhc.springcode;

import com.xhc.springcode.bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
/*@ComponentScan(basePackages = "com.xhc.springcode.scan",
               excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value={Service.class}),
                                 @ComponentScan.Filter(type= FilterType.ASPECTJ,pattern = "*..User1")})*/
/*@ComponentScan(basePackages = "com.xhc.springcode.scan",
               useDefaultFilters = false,
               includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value={Service.class})})*/
@ComponentScan(basePackages = "com.xhc.springcode.scan")
@Import(User.class)
public class AppConfig2 {

}
