package com.me.controller;

import com.me.exception.EmailException;
import com.me.exception.MyUserException;
import com.me.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理的步骤：
 *      1.新建自定义异常类MyUserException,再定义他的子类NameException,AgeException
 *      2.创建一个普通类，作用全局异常处理类
 *          在类的上面加入@ControllerAdvice
 *          在类中定义方法，方法上面加入@ExceptionHandler
 *      3.创建处理异常的视图界面
 *      4.创建springmvc的配置文件
 *          组件扫描器，扫描@Controller注解
 *          组件扫描器，扫描@ControllerAdvice注解
 *          声明注解驱动
 */
@Controller
public class StudentController {


    @RequestMapping("/some.do")
    public ModelAndView dosome(String name, String gender, String email) throws MyUserException {
        ModelAndView modelAndView = new ModelAndView();
        // 根据请求参数抛出异常
        if(!"zhangsan".equals(name)) {
            throw new NameException("姓名不正确");
        }

        if(email == null || email.equals("")) {
            throw new EmailException("邮箱不正确");
        }

        modelAndView.addObject("name", name);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("email", email);
        modelAndView.setViewName("show");
        return modelAndView;
    }


}
