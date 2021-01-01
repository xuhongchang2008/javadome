package com.xhc.springcode.service;

import com.xhc.springcode.entity.User;

public interface UserService {
    public void register(User user) throws Exception;

    public void login(String name,String password);
}
