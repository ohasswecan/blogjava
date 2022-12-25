package com.ctfstar.myblog.web.controller.admin;


import com.ctfstar.myblog.web.constant.LoginConstant;
import com.ctfstar.myblog.web.pojo.Admin;
import com.ctfstar.myblog.web.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.ServerEndpoint;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;
    @RequestMapping
    public String loginpage(){
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession httpSession,
                        RedirectAttributes attributes,
                        HttpServletResponse response){
        Admin admin = adminService.checkAdmin(username,password);
        System.out.println(admin);
        if(admin != null){
            admin.setPassword(null);
            httpSession.setAttribute(LoginConstant.ADMIN_USER,admin);
            Cookie c1=new Cookie("email",admin.getEmail());
            Cookie c2=new Cookie("username", admin.getUsername());
            response.addCookie(c1);
            response.addCookie(c2);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response,HttpSession session){
        Cookie c1=new Cookie("email",null);
        Cookie c2=new Cookie("username", null);
        response.addCookie(c1);
        response.addCookie(c2);
        session.invalidate();
        return "redirect:/admin";
    }


}
