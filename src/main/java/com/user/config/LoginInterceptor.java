package com.user.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //用户发送登录请求 放行
        System.out.println("uri: " + request.getRequestURI());


        if (request.getRequestURI().contains("judgeLogin")) {
            return true;
        }



        //用户通过登录验证 存在Session 放行
        if(session.getAttribute("userName") != null){
            return true;
        }

        //用户未登录 不存在Session 跳转到login.jsp页面 不放行
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request , response);
        return false;


    }
}
