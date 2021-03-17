package com.me.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyInterceptor implements HandlerInterceptor {

    // 验证登陆的用户信息, 正确应该return true
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logInName = "";
        // 从session中获取name的值
        Object name = request.getSession().getAttribute("name");
        if (name != null) {
            logInName = (String) name;
        }
        // 判断登陆的账户是否符合要求
        if(!"zhangsan".equals(logInName)) {
            // 不能访问系统，给用户提示
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
        return true;
    }

}
