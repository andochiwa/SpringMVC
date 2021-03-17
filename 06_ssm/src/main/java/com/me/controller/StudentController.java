package com.me.controller;

import com.me.pojo.Student;
import com.me.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        String tips = "注册失败";
        // 调用service处理student
        int nums = studentService.addStudent(student);
        if(nums > 0) {
            tips = "学生【" + student.getName() + "】注册成功";
        }
        // 指定结果页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips", tips);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    // 处理查询，响应ajax
    @RequestMapping("/queryStudents.do")
    @ResponseBody
    public List<Student> queryStudents() {
        // 参数检查，简单的数据处理
        return studentService.findStudent();
    }

}
