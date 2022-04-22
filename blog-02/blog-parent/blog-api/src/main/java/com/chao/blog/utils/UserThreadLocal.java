package com.chao.blog.utils;

import com.chao.blog.dao.pojo.SysUser;

public class UserThreadLocal {

    private  UserThreadLocal(){}

    private static final ThreadLocal<SysUser> LOCAL=new ThreadLocal<SysUser>();

    public static void put(SysUser user){
        LOCAL.set(user);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }

}
