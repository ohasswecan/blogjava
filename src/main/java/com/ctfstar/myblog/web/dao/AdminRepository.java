package com.ctfstar.myblog.web.dao;


import com.ctfstar.myblog.web.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AdminRepository extends JpaRepository<Admin,Long> {
        Admin findByUsernameAndPassword(String username,String password);

}
