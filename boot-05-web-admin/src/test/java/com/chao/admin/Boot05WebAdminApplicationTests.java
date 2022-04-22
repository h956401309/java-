package com.chao.admin;

import com.alibaba.druid.pool.DruidDataSource;
import com.chao.admin.bean.User;
import com.chao.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        //操作数据库jdbc操作
//        jdbcTemplate.queryForList("select * from user");
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("记录总数:{}",aLong);
        log.info("dataSource:{}",dataSource);
    }

    @Autowired
    UserMapper userMapper;

    @Test
    void  test1(){
        User user=userMapper.selectById(1L);
        log.info("用户信息：{}",user);
    }

}
