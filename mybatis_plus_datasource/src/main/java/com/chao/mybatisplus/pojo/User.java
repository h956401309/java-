package com.chao.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer uid ;

    private String name ;

    private Integer age;

    private Integer sex;

    private String email;

    private Integer isDelete;



}
