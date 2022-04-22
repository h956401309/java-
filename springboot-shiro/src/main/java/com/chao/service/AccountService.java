package com.chao.service;

import com.chao.entity.Account;
import org.springframework.stereotype.Service;


public interface AccountService {
    public Account findByUsername(String username);
}
