package com.xhc.springcode.factory;

import com.xhc.springcode.proxy.User;

public class UserServiceImpl implements UserService {
    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }
}
