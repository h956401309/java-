package com.chao.blog.service;

import com.chao.blog.dao.pojo.SysUser;
import com.chao.blog.vo.ArticleBodyVo;
import com.chao.blog.vo.Result;
import com.chao.blog.vo.UserVo;

public interface SysUserService {

     UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    //根据token查询用户信息
    Result finUserByToken(String token);


    //根据账户查找用户
    SysUser findUserByAccount(String account);

    //保存用户
    void save(SysUser sysUser);



}
