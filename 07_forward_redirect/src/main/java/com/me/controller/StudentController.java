package com.me.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/student")
public class StudentController {


    /**
     * 处理器方法返回ModelAndView，实现请求转发
     * 语法：setViewName("forward:视图文件完整路径")
     * 特点：不和视图解析器一起使用，就当没有视图解析器
     */
    @RequestMapping("/doforward.do")
    public ModelAndView dosome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "message");
        modelAndView.addObject("fun", "function");
        modelAndView.setViewName("forward:/WEB-INF/view/other.jsp");
        return modelAndView;
    }

    /**
     * 实现重定向
     * 语法：setViewName("redirect:视图完整路径")
     */
    @RequestMapping("/doredirect.do")
    public ModelAndView doRedirect() {
        ModelAndView modelAndView = new ModelAndView();
        // 数据存入request作用域
        modelAndView.addObject("msg", "message");
        modelAndView.addObject("fun", "function");
        modelAndView.setViewName("redirect:/other.jsp");
        return modelAndView;
    }


}
