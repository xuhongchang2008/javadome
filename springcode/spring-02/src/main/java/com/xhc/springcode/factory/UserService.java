package com.xhc.springcode.factory;

import com.xhc.springcode.proxy.User;

public interface UserService {
    public void login(String name, String password);

    public void register(User user);
}
