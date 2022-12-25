package com.ctfstar.myblog.web.controller;

import com.ctfstar.myblog.web.service.CommentService;
import com.ctfstar.myblog.web.service.impl.BlogServiceImpl;
import com.ctfstar.myblog.web.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private TypeServiceImpl typeService;

    @Autowired
    private CommentService commentService;
    @RequestMapping("/")
    public String Index(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("recommend",blogService.listRecommendBlogTop(8));
        return "index";
    }

    @RequestMapping("/blog")
    public String getblog(){
        return "blog";
    }

    @RequestMapping("/search")
    public String search(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("page",blogService.listBlogByQuery("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }


    @RequestMapping("/blog/{id}")
    public String readblog(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        model.addAttribute("comments",commentService.listCommentByBlogid(id));
        return "blog";
    }


    @RequestMapping("/fenlei")
    public String fenlei(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                         Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("typeid",null);
        return "fenlei";
    }

    @RequestMapping("/fenlei/{id}")
    public String getblogbyfenlei(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                                  @PathVariable Long id,Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlogBytypeid(id,pageable));
        model.addAttribute("typeid",id);
        return "fenlei";
    }


    @RequestMapping("/ctfstar")
    public String me(){
        return "aboutme";
    }
}
