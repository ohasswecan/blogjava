package com.ctfstar.myblog.web.service;

import com.ctfstar.myblog.web.pojo.Admin;

public interface AdminService {

    Admin checkAdmin(String username,String password);
}
