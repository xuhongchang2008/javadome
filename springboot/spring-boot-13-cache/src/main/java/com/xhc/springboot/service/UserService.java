package com.xhc.springboot.service;

import com.xhc.springboot.entities.User;
import com.xhc.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Auther: xhc
 */
//指定缓存公共属性值
@CacheConfig(cacheNames="user")
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * cacheNames 缓存名字
     * key:缓存容器中的key值, 方法返回值是value值
     * @param id
     * @return
     */
    //必须 指定一个缓存名称，不指定报500
    @Cacheable(/*cacheNames = "user",*/ key = "#id")
    public User getUserById(Integer id){

        User user = userMapper.getUserById(id);
        return user;
    }

    /**
     * http://localhost:8080/updateUser?username=123&realName=222&password=123&gender=2&userType=2&id=1
     * @param user
     * @return
     */
    //cacheNames = "user"
    //必须 指定一个缓存名称，不指定报500
    @CachePut(/*cacheNames = "user",*/ key="#result.id")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }


    /**
     * 默认情况下删除数据不会将缓存中的数据删除
     * allEntries = true 会将缓存中的所有数据清空
     * beforeInvocation = true， 为true的时候会先调用缓存清空
     * @param id
     * @return
     */
    @CacheEvict(/*cacheNames = "user",*/ key="#id", allEntries = true/*, beforeInvocation = true*/)
    public Integer deleteUserById(Integer id){
//        int i = 1/0;
        userMapper.deleteUserById(id);
        return id;
    }


}
