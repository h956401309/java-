package com.chao.blog.service;

import com.chao.blog.vo.Result;
import com.chao.blog.vo.params.CommentParam;

public interface CommentsService {

    //根据文章id查询所有评论列表
    Result commentsByArticle(Long id);

    Result comment(CommentParam commentParam);
}
