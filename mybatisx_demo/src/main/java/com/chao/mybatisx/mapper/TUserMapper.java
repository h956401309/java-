package com.chao.mybatisx.mapper;
import org.apache.ibatis.annotations.Param;

import com.chao.mybatisx.pojo.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.chao.mybatisx.pojo.TUser
 */
public interface TUserMapper extends BaseMapper<TUser> {

    int insertSelective(TUser tUser);

    int deleteByUid(@Param("uid") Long uid);

    int deleteByNameAndUid(@Param("name") String name, @Param("uid") Long uid);


    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<TUser> selectAgeAndSexByNameLike(@Param("name") String name);

    List<TUser> selectAllByAgeOrderByAge(@Param("age") Integer age);
}




