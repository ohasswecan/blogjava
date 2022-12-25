package com.ctfstar.myblog.web.dao;

import com.ctfstar.myblog.web.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface TypeRepository extends JpaRepository<Type,Long> {


    @Query("select t from t_type t")
    List<Type> findTop(Pageable pageable);
}
