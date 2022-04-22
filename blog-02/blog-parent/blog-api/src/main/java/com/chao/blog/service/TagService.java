package com.chao.blog.service;

import com.chao.blog.vo.Result;
import com.chao.blog.vo.TagVo;

import java.util.List;

public interface TagService {

    //根据文章id查询文章列表
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    //查询所有文章
    Result findAll();

    Result findAllDetail();

    Result findDetailById(Long id);
}
