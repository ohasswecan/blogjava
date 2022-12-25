package com.ctfstar.myblog.web.service.impl;

import com.ctfstar.myblog.web.dao.AdminRepository;
import com.ctfstar.myblog.web.pojo.Admin;
import com.ctfstar.myblog.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminRepository adminRepository;
    @Override
    public Admin checkAdmin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username,password);
    }
}
