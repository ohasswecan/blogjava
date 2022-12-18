package com.ctfstar.myblog.web.aspect;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LogAspect {

    private Logger loginfo= LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(* com.ctfstar.myblog.web.*.*.*(..))")
    public void log(){};

    @Before("log()")
    public void dobefore(){
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest=servletRequestAttributes.getRequest();
        String url=httpServletRequest.getRequestURL().toString();
        String ip=httpServletRequest.getRemoteAddr();

        loginfo.info("getRequestboyandgirl,{}",new Requestboyandgirl(url,ip));

    }

    @After("log()")
    public void doafter(){

    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doafterreturning(Object result){

    }


    private class Requestboyandgirl{
        private String url;
        private String ip;

        public Requestboyandgirl(String url, String ip) {
            this.url = url;
            this.ip = ip;
        }

        @Override
        public String toString() {
            return "Requestboyandgirl{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    '}';
        }
    }
}
