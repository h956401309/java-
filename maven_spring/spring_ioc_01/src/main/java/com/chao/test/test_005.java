package com.chao.test;

import com.chao.Config.SpringConfig;
import com.chao.hu.Student;
import com.chao.zhujie.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test_005 {

    @Test
    public void test001() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.test001();
    }


    @Test
    public void test() {
        //加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_zhujie.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.test001();


    }
}
