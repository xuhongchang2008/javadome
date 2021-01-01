package com.xhc.springboot.controller;

import com.xhc.springboot.entities.User;
import com.xhc.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: xhc
 */
@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public String login (HttpSession session, String username, String password, Map<String, Object> map) {

        if( !StringUtils.isEmpty(username)
                && !StringUtils.isEmpty(password) ) {

            //查询数据库用户是否存在
            User user = userMapper.getUserByUsername(username);
            if(user != null && password.equals(user.getPassword())) {
                //登录成功
//                session.setAttribute("loginUser", user.getUsername());
                session.setAttribute("loginUser", user);
                //重定向 redirect：可以重定向到任意一个请求中（包括其他项目），地址栏改变
                return "redirect:/main.html";
            }

        }

        //登录失败
        map.put("msg", "用户名或密码错误");

        return "main/login";
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //1. 清空session中的用户信息
        session.removeAttribute("loginUser");
        //2. 再将session进行注销
        session.invalidate();
        //3. 返回登录页面
        return "redirect:/index.html";
    }

}
