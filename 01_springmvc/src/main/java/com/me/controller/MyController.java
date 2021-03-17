package com.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller 创建控制器对象，对象放在springmvc容器中
 *
 */
@Controller
public class MyController {

    /*
      处理用户提交的请求
      springmvc中使用方法来处理
      方法是自定义的，可以有多种返回值
     */

    /**
     * 准备使用doSome方法处理some.do请求
     * @RequestMapping 请求映射，作用是把一个请求地址和一个方法绑定在一起
     *  属性：
     *      1.value 是一个String，表示请求的url地址，必须是唯一的
     *      使用时推荐地址以"/"开头
     *  位置：
     *      1.在方法的上面，常用
     *      2.在类上面
     *
     *  说明：
     *      使用RequestMapping修饰的方法叫做处理器/控制器方法
     *      使用@RequestMapping修饰的方法可以处理请求，类似Servlet的doGet/doPost
     *
     *  返回值：ModelAndView 表示本次请求的处理结果
     *      model:数据，请求处理完成后，要显示给用户的数据
     *      view: 视图，比如jsp等等
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome() {
        ModelAndView modelAndView = new ModelAndView();
        // 添加数据, 框架在请求的最后把数据放入到request作用域
        // 相当于request.setAttribute("msg", "欢迎使用springmvc做web开发")
        modelAndView.addObject("msg", "欢迎使用springmvc做web开发");
        modelAndView.addObject("fun", "执行的是doSome方法");

        // 指定视图, 指定视图的完整路径
        // 框架对视图执行的forward操作, request.getRequestDispatcher("/show.jsp").forward(...)

        // modelAndView.setViewName("/WEB-INF/view/show.jsp");
        // modelAndView.setViewName("/WEB-INF/view/other.jsp");

        // 当配置了视图解析器后，可以使用逻辑名称（文件名）指定视图->springmvc.xml
        // 框架会使用视图解析器的前缀 + 逻辑名称 + 后缀组合完成路径
        modelAndView.setViewName("show");


        return modelAndView;
    }

}
