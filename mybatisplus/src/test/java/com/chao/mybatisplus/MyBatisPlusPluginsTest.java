package com.chao.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chao.mybatisplus.mapper.ProductMapper;
import com.chao.mybatisplus.mapper.UserMapper;
import com.chao.mybatisplus.pojo.Product;
import com.chao.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test(){
        Page<User> page=new Page<User>(2,3);


        Page<User> userPage = userMapper.selectPage(page, null);
        //当前页数据
        System.out.println(userPage.getRecords());

        //当前页
        System.out.println(userPage.getCurrent());
        //当前页数据个数
        System.out.println(userPage.getSize());


        //总页数
        System.out.println(userPage.getPages());
        //总记录数
        System.out.println(userPage.getTotal());
        //是否由下一页
        System.out.println(userPage.hasNext());
        //是否由上一页
        System.out.println(userPage.hasPrevious());
    }




    @Test
    public void testPageVo(){

        //自定义方法进行分页
        Page<User> page = new Page<>(4,3);
        Page<User> userPage = userMapper.selectPageVo(page, 20);
        System.out.println(userPage);
    }



    @Test
    public void testProduct01(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询价格"+productLi.getPrice());
        //小王查询价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询价格"+productWang.getPrice());
        //小李增加50块
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        System.out.println("小李修改后价格"+productLi.getPrice());


        //小王减少20块
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if(result ==0){
            //重新操作
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        System.out.println("小王修改后价格"+productWang.getPrice());

        //l
        Product productLaoban = productMapper.selectById(1);
        System.out.println("老板查询价格"+productLaoban.getPrice());
    }
}
