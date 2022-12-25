//package com.ctfstar.myblog.web.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.*;
//
//import java.util.List;
//
//
//@Configuration
//public class webConfig extends WebMvcConfigurationSupport{
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).
//                addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin")
//                .excludePathPatterns("/admin/login")
//                .excludePathPatterns("/static/**");
//    }
//
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        // Spring data jpa pageable的参数分解器
//        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
//    }
//
//
//}