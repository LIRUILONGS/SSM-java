package com.liruilong.controller;

import com.liruilong.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2021/6/1 11:26
 * @Created Li Ruilong
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;
    @GetMapping(value = "/hello",produces = "text/html;charset=utf-8")
    public String hello() {
        String hello = helloService.hello();
        System.out.println("hello = " + hello);
        return "hello ssm";
    }
}
