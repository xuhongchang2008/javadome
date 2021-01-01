package com.xhc.springcode.aop;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void register() {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login() {
        System.out.println("UserServiceImpl.login");
    }
}
