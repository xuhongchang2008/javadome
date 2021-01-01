package com.xhc.springboot.service.impl;

import com.xhc.springboot.dao.UserRepository;
import com.xhc.springboot.entity.User;
import com.xhc.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模拟事务管理
 * @Auther: xhc
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    //isolation指定隔离级别， propagation传播行为
    @Transactional(isolation = Isolation.DEFAULT, propagation= Propagation.REQUIRED) //当前方法开启事务管理
    @Override
    public Boolean addUser(User user) {

        //模拟转帐：转出
        userRepository.save(new User("1", "1"));
        userRepository.save(new User("12", "2"));
        userRepository.save(new User("123", "3"));
        userRepository.save(new User("1234", "4"));
        userRepository.save(new User("12345", "5"));


        //转入：模拟失败了
        //userRepository.save(new User("123456", "6"));
        //userRepository.save(new User("1234567", "7"));

        userRepository.save(user);

        return null;
    }
}
