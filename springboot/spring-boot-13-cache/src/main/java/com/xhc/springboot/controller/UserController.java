package com.xhc.springboot.controller;

import com.xhc.springboot.entities.User;
import com.xhc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xhc
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return user;
    }


    @GetMapping("/updateUser")
    public User updateUser(User user){
        userService.updateUser(user);
        return user;
    }

    @GetMapping("/deleteUser/{id}")
    public Integer deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return id;
    }


}
