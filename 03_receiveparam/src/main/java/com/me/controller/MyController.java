package com.me.controller;

import com.me.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    /**
     * 逐个接收请求参数
     *      要求: 处理器方法的形参名和请求中的参数名必须一致
     *           同名的请求参数赋值给同名的形参
     *       框架接收请求参数
     *          1.使用request对象来接收请求参数
     *            String name = request.getParameter("name");
     *            String age = request.getParameter("age");
     *          2.springmvc框架通过DispatcherServlet调用MyController的doSome()方法
     *            调用方法时, 按名称对应, 把接收的参数赋给形参
     *            doSome(strName, Integer.valueOf(strAge))
     *            框架会提供类型转换的功能, 能把String转换为int, long, float, double等类型
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doFirst(String name, Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     * @RequestParam 解决请求中参数名和形参名不一样的问题
     *      属性: 1.value 请求中的参数名称
     *           2.required 是个boolean, 默认为true
     *              true: 表示请求中必须包含此参数
     *              false: 请求中可以不包含此参数
     *
     *      位置: 在处理器方法的形参定义前面
     */
    @RequestMapping(value = "/receiveParam.do")
    public ModelAndView receiveParam(@RequestParam("rname") String name, @RequestParam("rage") Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 使用对象来接受请求参数
     */
    @RequestMapping(value = "/receiveObject.do")
    public ModelAndView receiveObject(Student student) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", student.getName());
        modelAndView.addObject("myage", student.getAge());
        modelAndView.addObject("mystudent", student);
        modelAndView.setViewName("show");
        return modelAndView;
    }

}
