package com.chao.realm;

import com.chao.entity.Account;
import com.chao.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AccountReaml extends AuthorizingRealm {


    @Autowired
    private AccountService accountService;
    //授权判断  登陆后权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取当前登录用户信息
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();

        //设置角色
        Set<String> roles=new HashSet<String>();
        roles.add(account.getRole());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //设置权限
        info.addStringPermission(account.getPerms());

        return info;
    }

    //认证  登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Account account = accountService.findByUsername(token.getUsername());
        if (account !=null) {
            return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }

        return null;
    }
}
