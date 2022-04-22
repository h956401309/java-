package com.chao.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.chao.realm.AccountReaml;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {




    @Bean
    public AccountReaml accountReaml(){
        return new AccountReaml();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountReaml") AccountReaml accountReaml){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(accountReaml);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager ){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        //认证和授权 权限设置
        Map<String,String> map=new HashMap<String,String>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);
        //设置登陆页面
        factoryBean.setLoginUrl("/login");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("/unath");
        return factoryBean;
    }


//    shiro整合thymeleaf
    @Bean
    public ShiroDialect ShiroDialect(){
        return new ShiroDialect();
    }


}
