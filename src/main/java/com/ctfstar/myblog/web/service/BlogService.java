package com.ctfstar.myblog.web.service;

import com.ctfstar.myblog.web.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable,Blog blog);

    Page<Blog> listBlog(Pageable pageable);
    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);


    Page<Blog> listBlogByQuery(String query,Pageable pageable);


    Blog getAndConvert(Long id);

    Page<Blog> listBlogBytypeid(Long typeid,Pageable pageable);
}
