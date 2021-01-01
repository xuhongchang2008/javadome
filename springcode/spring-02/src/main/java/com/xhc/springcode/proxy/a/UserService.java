package com.xhc.springcode.proxy.a;

import com.xhc.springcode.proxy.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
