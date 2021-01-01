package com.xhc.springcode;

import com.xhc.springcode.bean.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.xhc.springcode.bean")
@ImportResource("applicationContext.xml")
public class AppConfig3 {

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("xiaojr");
        return customer;
    }
}
