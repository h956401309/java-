package com.chao.mybatisplus;

import com.chao.mybatisplus.pojo.User;
import com.chao.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        //查询总记录数                 SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数"+count);
    }

    @Test
    //批量添加              INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
    public void test01(){
        List<User> list=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            User user=new User();
            user.setName("hzc"+i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);

    }
}
