package com.xhc.springboot.controller;

import com.xhc.springboot.entities.User;
import com.xhc.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 用户管理的控制层
 * @Auther: xhc
 */
@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public String list(Map<String, Object> map, User user) {
        logger.info("用户列表查询。。。" + user);

        List<User> users = userMapper.getUsers(user);

        map.put("users", users);
        map.put("username", user.getUsername());

        return "user/list";
    }

    /**
     * type = null 进入查看详情页面view.html，
     * type=update 则是进入update.html
     */
    @GetMapping("/user/{id}")
    public String view(@PathVariable("id") Integer id,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + id + "的用户详细信息");

        User user = userMapper.getUserById(id);

        map.put("user", user);

        // type = null 则进入view.html， type=update 则是进入update.html
        return "user/" + type;
    }

    //修改
    @PutMapping("/user")
    public String update(User user) {
        logger.info("更改用户信息。。。");
        //更新操作
        userMapper.updateUser(user);

        return "redirect:users";
    }

    //前往添加 页面
    @GetMapping("/user")
    public String toAddPage() {
        return "user/add";
    }


    //添加数据
    @PostMapping("/user")
    public String add(User user) {
        logger.info("添加用户数据" + user);
        //保存数据操作
        userMapper.addUser(user);

        return "redirect:/users";
    }

    //删除
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id) {
        logger.info("删除操作, pid=" + id);

        userMapper.deleteUserById(id);

        return "redirect:/users";
    }

    //前往密码修改页面
    @GetMapping("user/pwd")
    public String toPwdUpdatePage() {
        return "/main/password";
    }

    //校验密码是否正确
    @ResponseBody
    @GetMapping("user/pwd/{oldPwd}")
    public Boolean checkPwd(@PathVariable("oldPwd") String oldPwd,
                             HttpSession session) {
        logger.info("输入的旧密码为：" + oldPwd);
        User user = (User) session.getAttribute("loginUser");
        if(user.getPassword().equals(oldPwd)) {
            return true;
        }
        return false;
    }

    @PostMapping("/user/pwd")
    public String updatePwd(HttpSession session, String password) {
        //获取session中的登录信息
        User user = (User) session.getAttribute("loginUser");
        //更新密码
        user.setPassword(password);
        userMapper.updateUser(user);

        //注销重新登录
        return "redirect:/logout";
    }

}
