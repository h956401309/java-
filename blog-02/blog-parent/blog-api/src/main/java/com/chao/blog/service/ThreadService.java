package com.chao.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chao.blog.dao.mapper.ArticleMapper;
import com.chao.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {


    @Async("taskExecutor")      //线程池中进行更新操作
    public void updataArticleViewCount(ArticleMapper articleMapper, Article article) {
        int viewCounts = article.getViewCounts();
        Article article1update = new Article();
        article1update.setViewCounts(viewCounts+1);
        LambdaQueryWrapper<Article> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        updateWrapper.eq(Article::getViewCounts,viewCounts);
        articleMapper.update(article1update,updateWrapper);
        System.out.println("==================================================运行了 结果是:"+article1update.getViewCounts());

    }
}
