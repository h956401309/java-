package com.chao.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chao.mybatisplus.mapper.UserMapper;
import com.chao.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){

        //查询用户名包含a 年龄在20，26之间，邮箱信息部位不为null的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        QueryWrapper<User> queryWrapper1 = queryWrapper.like("name", "i")
                .between("age", "20", "30")
                .isNotNull("email");

        // SELECT uid AS id,name,email,age,is_delete FROM t_user WHERE is_delete=0
        // AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        List<User> users = userMapper.selectList(queryWrapper1);
        System.out.println(users);

    }


    @Test
    public void test02(){
        //查询用户信息，按照年龄的降序排序，若年龄相同，按照id升序排序
        //SELECT uid AS id,name,email,age,is_delete FROM t_user WHERE is_delete=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    @Test
    public void test03(){
        //删除邮箱地址为null的
        //逻辑删除
        //UPDATE t_user SET is_delete=1 WHERE is_delete=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    @Test
    public void test04(){

        //将（年龄大于20并且用户名中包含a）或者邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age","20").like("name","a").or().isNotNull("email");
        User user=new User();
        user.setName("小明");
        user.setEmail("1234567@qq.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);

    }


    @Test
    public void test05(){

        //用户名中包含a并且（年龄大于20或邮箱为null）的用户信息修改

        //UPDATE t_user SET name=?, email=? WHERE is_delete=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a").and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("小天");
        user.setEmail("1@qq.com");

        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }


    @Test
    public void test06(){

        //查询年龄，用户名，邮箱信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        //
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
    }

    @Test
    public void test07(){
        //组装子查询
        //  查询id<=100的用户信息
        //SELECT uid AS id,name,email,age,is_delete
        //FROM t_user WHERE is_delete=0 AND (uid IN (select uid from t_user where uid<=100))
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid<=100");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    @Test
    public void test08(){
        //将用户名中包含a并且（年龄大于20或者邮箱为null）的用户修改
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<User>();
        updateWrapper.like("name","a").and(i->i.gt("age","20").or().isNull("email"));
        updateWrapper.set("name","xiaohei").set("email","111111111111");
        int update = userMapper.update(null, updateWrapper);
        System.out.println("updata::::::"+update);


    }


}
