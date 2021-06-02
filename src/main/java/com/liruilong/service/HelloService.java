package com.liruilong.service;

import org.springframework.stereotype.Service;

/**
 * @Classname HelloService
 * @Description TODO
 * @Date 2021/6/1 11:31
 * @Created Li Ruilong
 */
@Service
public class HelloService {

    public String hello() {
        return "hello service";
    }
}
