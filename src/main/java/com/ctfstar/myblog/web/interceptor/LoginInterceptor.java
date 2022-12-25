package com.ctfstar.myblog.web.interceptor;

import com.ctfstar.myblog.web.constant.LoginConstant;
import com.ctfstar.myblog.web.pojo.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Admin admin =(Admin) session.getAttribute(LoginConstant.ADMIN_USER);
        if(admin ==null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
