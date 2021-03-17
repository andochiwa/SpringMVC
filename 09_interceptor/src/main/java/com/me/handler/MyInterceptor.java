package com.me.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器类，拦截用户的请求
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 预处理方法
     * Object handler: 被拦截的控制器对象
     * 返回值boolean
     *      true: 通过了拦截器的验证，放行
     *      false: 不放行
     *
     *  特点：
     *      1.方法在控制器执行前先执行
     *        用户的请求首先到达此方法
     *      2.在这个方法中可以获取请求的信息，验证请求是否请求要求
     *        可以验证用户是否登录，验证用户是否有权限访问某个地址
     *        如果验证失败，可以截断请求，请求不能被处理
     *        如果验证成功，可以放心请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1拦截器的preHandle方法");
        // 给浏览器返回一个结果
//        request.getRequestDispatcher("/tips.jsp").forward(request, response);
        return true;
    }

    /**
     * 后处理方法
     * Object handler: 被拦截的控制器方法
     * ModelAndView modelAndView: 处理器方法的返回值
     *
     * 特点：
     *      1.在处理器方法执行之后执行
     *      2.能够获取处理器方法的返回值ModelAndView
     *        可以修改ModelAndView中的数据和视图
     *        可以影响到最后的执行结果
     *      3.主要对原来的执行结果做二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 对原来的dosome执行结果进行调整
        if(modelAndView != null) {
            modelAndView.addObject("date", new Date());
            modelAndView.setViewName("other");
        }
        System.out.println("1拦截器的postHandle方法");
    }

    /**
     * 最后执行的方法
     * Object handler: 被拦截的处理器对象
     * Exception ex: 程序中发生的异常
     *
     * 特点：
     *      1.在请求处理完成后执行，框架中规定视图处理完成后
     *        对视图执行了forward后就认为处理已完成
     *      2.一般做回收工作，程序请求过程中创建了一些对象，在这里可以删除
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("1拦截器的afterCompletion方法");
    }
}
