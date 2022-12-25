package com.ctfstar.myblog.web.service;

import com.ctfstar.myblog.web.pojo.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> listCommentByBlogid(Long blogId);

    Comment savecomment(Comment comment);
}
