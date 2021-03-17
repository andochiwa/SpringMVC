package com.me.handler;

import com.me.exception.EmailException;
import com.me.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice 控制器通知（给控制器类增加功能--异常处理）
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /*
        定义方法，处理异常
        处理异常的方法和控制器方法定义一样，可以有多个参数，ModelAndView，返回值
     */

    /**
     *
     * @ExceptionHandler 表示异常的类型，当发生此类型异常时，由当前方法处理
     * @param exception 表示Controller中抛出的异常对象
     *                  通过形参获取异常发生的详细信息
     */
    @ExceptionHandler(NameException.class)
    public ModelAndView doNameException(Exception exception) {
        // 处理NameException的异常
        /*
            异常处理的逻辑：
            1.需要把异常记录下来，记录到数据库，日志文件
              记录日志发生的时间，发生的方法，错误内容
            2.发送通知，把异常的信息通过邮件，短信，微信等发送给相关人员
            3.给用户友好提示
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "姓名必须为张三，否则不能访问");
        modelAndView.addObject("ex", exception);
        modelAndView.setViewName("nameError");
        return modelAndView;
    }

    /**
     * 处理邮箱错误异常
     */
    @ExceptionHandler(EmailException.class)
    public ModelAndView doEmailException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "邮箱不能为空");
        modelAndView.addObject("ex", exception);
        modelAndView.setViewName("emailError");
        return modelAndView;
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "其他异常");
        modelAndView.addObject("ex", exception);
        modelAndView.setViewName("otherError");
        return modelAndView;
    }
}
