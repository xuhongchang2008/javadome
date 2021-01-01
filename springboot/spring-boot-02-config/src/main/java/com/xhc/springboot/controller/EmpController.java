package com.xhc.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title: EmpController
 * @Description: com.xhc.springboot.controller
 * @Auther: www.xhc.com
 * @Version: 1.0
 */
@Controller
public class EmpController {

    @Value("${emp.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("/say")
    public String sayHello() {
        return "say hello " + name;
    }


}
