package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
