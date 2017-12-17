package com.manajay.cay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始化
 * @author manajay
 * @date 2017-12-15
 */

/**
 * RestController spring4后增加的注解 相当于 responseBody与Controller
 */
@RestController
public class HelloWorld {

    @Value("${mywebsite}")
    private String mywebsite;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String hello(){
        return mywebsite;
    }
}
