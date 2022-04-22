package com.chao.mybatisplus;

import com.chao.mybatisplus.pojo.Product;
import com.chao.mybatisplus.pojo.User;
import com.chao.mybatisplus.service.ProductService;
import com.chao.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDatasourceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @Test
    public void test(){
        User byId = userService.getById(1);
        System.out.println(byId);
        Product byId1 = productService.getById(1);
        System.out.println(byId1);

    }

}
