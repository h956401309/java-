package com.chao.blog.controller;

import com.chao.blog.service.LoginService;
import com.chao.blog.vo.Result;
import com.chao.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    LoginService loginService;      //注册功能 复用 loginService

    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){

        return loginService.register(loginParam);
    }
}
