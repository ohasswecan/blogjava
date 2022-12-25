package com.ctfstar.myblog.web.controller;


import com.ctfstar.myblog.web.pojo.Comment;
import com.ctfstar.myblog.web.service.BlogService;
import com.ctfstar.myblog.web.service.CommentService;
import com.ctfstar.myblog.web.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/comments/{blogId}")
    public String comment(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogid(blogId));

        return "blog :: commentList";
    }

    @RequestMapping("/comments")
    public String commentsubmit(Comment comment){
        Long blogId=comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        commentService.savecomment(comment);
        System.out.println(blogId);
        return "redirect:/comments/"+blogId;
    }
}
