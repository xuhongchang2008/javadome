package com.xhc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: xhc
 */
@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public String execute() {
        return "hello world";
    }

}
