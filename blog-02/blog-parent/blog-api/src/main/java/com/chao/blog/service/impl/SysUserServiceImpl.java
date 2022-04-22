package com.chao.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chao.blog.dao.mapper.SysUserMapper;
import com.chao.blog.dao.pojo.SysUser;
import com.chao.blog.service.LoginService;
import com.chao.blog.service.SysUserService;
import com.chao.blog.utils.JWTUtils;
import com.chao.blog.vo.ErrorCode;
import com.chao.blog.vo.LoginUserVo;
import com.chao.blog.vo.Result;
import com.chao.blog.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LoginService loginService;

    @Override
    public UserVo findUserVoById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser=new SysUser();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/img/logo.b3a48c0.png");
            sysUser.setNickname("超超博客");
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(sysUser,userVo);
        return userVo;
    }

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser=new SysUser();
            sysUser.setNickname("超超博客");
        }
        return sysUserMapper.selectById(id);
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>();
        query.eq(SysUser::getAccount,account);
        query.eq(SysUser::getPassword,password);
        query.select(SysUser::getAccount,SysUser::getId,SysUser::getAvatar,SysUser::getNickname);
        query.last("limit 1");
        return sysUserMapper.selectOne(query);
    }

    @Override
    public Result finUserByToken(String token) {
        //1.token合法性校验   是否为空 解析是否成功  redis是否存在
        //2.如果校验失败 返回错误
        //3.如果成功 返回对应结果 LoginUserVo


        SysUser user=loginService.checkToken(token);
        if (user==null){
            return  Result.fail(ErrorCode.TOKEN_EOORO.getCode(),ErrorCode.TOKEN_EOORO.getMsg());
        }
        LoginUserVo loginUserVo=new LoginUserVo();
        loginUserVo.setId(user.getId());
        loginUserVo.setAccount(user.getAccount());
        loginUserVo.setNickname(user.getNickname());
        loginUserVo.setAvatar(user.getAvatar());
        return Result.success(loginUserVo);
    }

    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>();
        query.eq(SysUser::getAccount,account);
        query.last("limit 1");
        return this.sysUserMapper.selectOne(query);

    }

    @Override
    public void save(SysUser sysUser) {
        //保存用户   id会自动生成
        //这里默认生成的id是分布式id  采用雪花算法

        this.sysUserMapper.insert(sysUser);
    }
}
