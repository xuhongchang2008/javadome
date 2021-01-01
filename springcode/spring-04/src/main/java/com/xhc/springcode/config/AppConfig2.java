package com.xhc.springcode.config;

import com.xhc.springcode.injection.UserDAO;
import com.xhc.springcode.injection.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }
}
