package com.chao.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chao.blog.dao.mapper.CommentMapper;
import com.chao.blog.dao.pojo.Comment;
import com.chao.blog.dao.pojo.SysUser;
import com.chao.blog.service.CommentsService;
import com.chao.blog.service.SysUserService;
import com.chao.blog.utils.UserThreadLocal;
import com.chao.blog.vo.CommentVo;
import com.chao.blog.vo.Result;
import com.chao.blog.vo.UserVo;
import com.chao.blog.vo.params.CommentParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public Result commentsByArticle(Long id) {
        /*
        * 1.根据文章id 查询评论列表 从comment表中查询
        * 2.根据作者id查询作者信息
        * 3.判断 如果level=1 要去查询他有没有子评论
        * 4.如果有根据评论id进行查询（parent_id）
        * */


        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<Comment>();
        queryWrapper.eq(Comment::getArticleId,id);
        queryWrapper.eq(Comment::getLevel,1);
        queryWrapper.orderByDesc(Comment::getCreateDate);
        List<Comment> comments = commentMapper.selectList(queryWrapper);

        List<CommentVo> commentVoList = copyList(comments);
        return Result.success(commentVoList);
    }



    private List<CommentVo> copyList(List<Comment> comments) {
        List<CommentVo> commentVoList = new ArrayList<CommentVo>();
        for(Comment comment:comments){
            commentVoList.add(copy(comment));
        }

        return commentVoList;
    }


    private CommentVo copy(Comment comment) {
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        //作者信息
        Long authorId=comment.getAuthorId();
        UserVo userVo = this.sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        //子评论
        Integer level = comment.getLevel();
        if(level==1)
        {
            Long id=comment.getId();
            List<CommentVo> commentVoList = findCommentsByParentId(id);
            commentVo.setChildrens(commentVoList);
        }

        //toUser给谁评论
        if (level>1){
            Long toUid = comment.getToUid();
            UserVo userVoById = this.sysUserService.findUserVoById(toUid);
            commentVo.setToUser(userVoById);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<Comment>();
        queryWrapper.eq(Comment::getParentId,id);
        queryWrapper.eq(Comment::getLevel,2);
        return copyList(commentMapper.selectList(queryWrapper));

    }



    @Override
    public Result comment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if (parent == null || parent == 0) {
            comment.setLevel(1);
        }else{
            comment.setLevel(2);
        }
        comment.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentParam.getToUserId();
        comment.setToUid(toUserId == null ? 0 : toUserId);
        this.commentMapper.insert(comment);
        return Result.success(null);
    }
}
