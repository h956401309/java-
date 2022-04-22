package com.chao.zhujie;

import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

    public void add() {
        System.out.println("UserDao++++++++");

    }
}
