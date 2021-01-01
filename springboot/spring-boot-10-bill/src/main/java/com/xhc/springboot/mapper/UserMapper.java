package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.User;

import java.util.List;

/**
 * @Auther: xhc
 */
//@Mapper 或 @MapperScan("com.xhc.springboot.mapper")
public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);

}
