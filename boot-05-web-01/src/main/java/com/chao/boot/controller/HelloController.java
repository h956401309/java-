package com.chao.boot.controller;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootConfiguration
public class HelloController {

    //请求进来 先去Controller查找 看能不能处理 不能处理的请求交给静态资源处理器。静态资源也找不到 报错404
    @RequestMapping("/001.jpg")
    public String hello(){
        return "aaa";
    }

//    @RequestMapping("/index")
//    public String index(){
//        return "你好 欢迎来到 index";
//    }



    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }



}
