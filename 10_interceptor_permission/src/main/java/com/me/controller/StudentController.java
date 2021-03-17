package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {

    @RequestMapping("/some.do")
    public ModelAndView dosome(String name, String gender, String email) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name", name);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("email", email);
        modelAndView.setViewName("show");
        return modelAndView;
    }


}
