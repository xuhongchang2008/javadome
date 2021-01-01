package com.xhc.springcode.mybatis_01;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    public void save(User user);
}
