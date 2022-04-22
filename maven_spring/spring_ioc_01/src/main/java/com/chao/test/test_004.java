package com.chao.test;

import com.chao.hu.Order;
import com.chao.hu.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_004 {


    @Test
    public void test() {
        //加载spring的配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("bean_zhujie.xml");
        Student stu = context.getBean("stu", Student.class);
        System.out.println(stu.toString());


    }
}
