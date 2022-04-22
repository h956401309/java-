package com.chao.blog.vo;

import lombok.Data;

@Data
public class LoginUserVo {
    private String account;

    private String nickname;

    private String avatar;

    private Long id;
}
