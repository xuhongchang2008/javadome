package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.User;

import java.util.List;

/**
 * @Auther: xhc
 */
public interface UserMapper {

    List<User> getUsers(User user);

    User getUserByUsername(String username);

    User getUserById(Integer id);


    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);

}
