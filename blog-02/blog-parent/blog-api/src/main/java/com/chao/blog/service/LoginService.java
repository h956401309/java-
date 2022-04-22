package com.chao.blog.service;

import com.chao.blog.dao.pojo.SysUser;
import com.chao.blog.vo.Result;
import com.chao.blog.vo.params.LoginParam;

public interface LoginService {
    //登录功能
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);


    //退出登录
    Result logout(String token);


    //注册功能
    Result register(LoginParam loginParam);
}
