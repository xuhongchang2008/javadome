package com.xhc.springcode.dao;

import com.xhc.springcode.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserDAO {
    public void save(User user);
}
