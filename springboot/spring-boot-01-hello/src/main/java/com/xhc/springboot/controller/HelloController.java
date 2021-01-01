package com.xhc.springboot.controller;

import com.demo.starter.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title: HelloController
 * @Description: com.xhc.springboot.controller
 * @Auther: www.xhc.com
 * @Version: 1.0
 */
@Controller
public class HelloController {

    @Resource(name = "demo")
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return demoService.say();
        //return "hello World...";
    }



    @RequestMapping("/say")
    public String sayWhat(){
        return demoService.say();
    }
}

