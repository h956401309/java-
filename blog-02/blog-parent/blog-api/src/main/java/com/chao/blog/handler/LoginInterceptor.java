package com.chao.blog.handler;


import com.alibaba.fastjson.JSON;
import com.chao.blog.dao.pojo.SysUser;
import com.chao.blog.service.LoginService;
import com.chao.blog.utils.UserThreadLocal;
import com.chao.blog.vo.ErrorCode;
import com.chao.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //再执行方法（Handler）之前执行

        /*
        * 1.需要判断请求的接口路径 是否为HandlerMethod
        * 2.判断token是否为空  如果为空 未登录
        * 3.如果token不为空 登录验证
        * 4.如果认证成功 方向即可
        *
        * */
        if (!(handler instanceof HandlerMethod)){
            //handler可能是 请求资源的
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");



        if (StringUtils.isBlank(token))
        {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser == null) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }

        //登录验证成功放行

        //希望在控制层中直接获取用户信息
        UserThreadLocal.put(sysUser);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除会有内存泄漏
        UserThreadLocal.remove();
    }
}
