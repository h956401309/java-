package com.chao.Config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//注解 设置配置类  代替xml配置文件
@Configuration
//设置注解 开启组件扫描
@ComponentScan(basePackages ={"aop_AspectJ"})
//开启动态代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
