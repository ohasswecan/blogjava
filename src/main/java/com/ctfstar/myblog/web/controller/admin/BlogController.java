package com.ctfstar.myblog.web.controller.admin;


import com.ctfstar.myblog.web.constant.LoginConstant;
import com.ctfstar.myblog.web.pojo.Admin;
import com.ctfstar.myblog.web.pojo.Blog;
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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private TypeServiceImpl typeService;
    @RequestMapping("/blogs")
    public String blog(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable
            ,Blog blog, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));

        return "admin/blogmanage";
    }

    @RequestMapping("/blogs/search")
    public String blogsearch(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable
            ,Blog blog, Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogmanage::blogList";
    }

    @RequestMapping("/blogs/write")
    public String write(Model model) {
        model.addAttribute("types",typeService.listType());
        model.addAttribute("blog",new Blog());
        return "admin/input";
    }

    @RequestMapping("/blogs/submit")
    public String submit(Blog blog, HttpSession httpSession){
        blog.setAdmin((Admin)httpSession.getAttribute(LoginConstant.ADMIN_USER));
        blog.setType(typeService.getType(blog.getType().getId()));
        blogService.saveBlog(blog);

        return "redirect:/admin/blogs";
    }

    @RequestMapping("/blogs/{id}/input")
    public String update(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.getBlog(id));
        model.addAttribute("types",typeService.listType());

        return "/admin/blogedit";
    }

    @RequestMapping("/blogs/{id}")
    public String updateblog(Blog blog,@PathVariable Long id){
        blogService.updateBlog(id,blog);
        System.out.println(blog);
        return "redirect:/admin/blogs";
    }


    @RequestMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }
}
