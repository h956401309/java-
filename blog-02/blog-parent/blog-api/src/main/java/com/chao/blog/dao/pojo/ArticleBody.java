package com.chao.blog.dao.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

@Data
public class ArticleBody {


    private Long id;
    private String content;
    private String ContentHtml;
    private Long articleId;
}
