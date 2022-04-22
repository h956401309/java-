package com.chao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chao.entity.Account;
import com.chao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountManager;

    @Override
    public Account findByUsername(String username) {
        QueryWrapper<Account> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return accountManager.selectOne(queryWrapper);
    }
}
