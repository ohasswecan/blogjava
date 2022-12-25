package com.ctfstar.myblog.web.dao;

import com.ctfstar.myblog.web.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Specification<Blog> blogSpecification, Pageable pageable);


    @Query("select b from  t_blog b where b.recommend= true")
    List<Blog> findTop(Pageable pageable);


    @Query("select b from t_blog b where b.title like ?1")
    Page<Blog> findByQuery(String query,Pageable pageable);


    @Query("select b from  t_blog b where b.type.id=?1")
    Page<Blog> findByTypeid(Long typeid,Pageable pageable);
}
