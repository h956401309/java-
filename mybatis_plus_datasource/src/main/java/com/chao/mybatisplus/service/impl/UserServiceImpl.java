package com.chao.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.mybatisplus.mapper.UserMapper;
import com.chao.mybatisplus.pojo.User;
import com.chao.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {
}
