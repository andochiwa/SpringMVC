package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping
 *      value: 所有请求地址的公共部分
 *      位置: 放在类的上面
 */
@Controller
@RequestMapping("/test")
public class MyController {

    /**
     * @RequestMapping 请求映射
     *      属性: method, 表示请求的方式. 值为RequestMethod的枚举值
     *          例如, 表示get请求方式, RequestMethod.GET
     *          post方式, RequestMethod.POST
     */
    // 指定some.do使用get请求方式
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc做web开发");
        modelAndView.addObject("fun", "执行的是doSome方法");
        modelAndView.setViewName("show");
        return modelAndView;
    }

    // 指定other.do使用post请求方式
    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc做web开发");
        modelAndView.addObject("fun", "执行的是doOther方法");
        modelAndView.setViewName("other");
        return modelAndView;
    }

    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response,
                                HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc做web开发" + request.getParameter("name"));
        modelAndView.addObject("fun", "执行的是doOther方法");
        modelAndView.setViewName("other");
        return modelAndView;
    }

}
