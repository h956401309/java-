package com.chao.zhujie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "userService")
public class UserService {

    @Value(value = "11")
    private int age;

    @Autowired
    private UserDao userDao;


    public void test001(){
        System.out.println("UserService+++++++++++"+age);
        userDao.add();
    }
}
