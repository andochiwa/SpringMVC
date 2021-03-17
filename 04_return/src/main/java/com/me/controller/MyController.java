package com.me.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {

    /**
     * 处理器方法返回String--表示逻辑视图名称, 需要配置视图解析器
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, Integer age) {
        System.out.println("doReturnView, name = " + name + ", age = " + age);
        // 可以手动添加数据到request作用域
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        // show 逻辑视图名称, 项目中配置了视图解析器
        // 框架对视图执行了forward转发操作
        return "show";
    }

    /**
     * void 不能表示数据，也不能表示视图
     * 在处理ajax请求时可以使用void返回值，通过HttpServletResponse输出数据，响应ajax请求
     * ajax请求服务器端返回的就是数据，和视图无关
     *
     * ajax主要使用json数据格式，实现步骤：
     *      1.加入处理json的工具依赖，springmvc默认使用jackson
     *      2.在springmvc配置文件之间加入 <mvc:annotation-driven/> 注解驱动
     *          json = objectMapper.writeValuesString(student);
     *      3.在处理器方法上面加入@ResponseBody注解
     *
     *  springmvc处理器返回Object，可以转为json输出到浏览器，响应ajax的内部原理
     *  1.<mvc:annotation-driven/> 注解驱动
     *      注解驱动实现的功能是，完成java对象到json，xml，text，二进制等数据的转换
     *      HttpMessageConverter接口：消息转换器
     *      功能：定义了java转为json，xml等数据格式的方法，这个接口有很多实现类，
     *      这些实现类完成java对象到json，java对象到xml等数据的转换
     *
     *      下面两个方法是控制器类把结果输出给浏览器时使用的
     *      boolean canWrite(Class<?> var1, @Nullable MediaType var2)
     *      void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)
     *
     *      1.canWrite作用检查处理器方法的返回值，能不能转为var2表示的数据格式
     *          例如注释的方法
     *          检查student(name, age)能不能转为var2表示的数据格式
     *          MediaType：表示数据格式，例如json，xml等
     *
     *      2.write：把处理器方法的返回值对象，调用jackson中的ObjectMapper转为json字符串
     */
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("doReturnVoidAjax, name = " + name + ", age = " + age);
        // 处理ajax，使用json做数据的格式
        // 认为service调用完成了，使用student表示结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        // 把结果对象转为json模式的数据
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);
        System.out.println("student转换的json===" + json);

        // 输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();

    }

    /**
     * 处理器返回Student, 通过框架返回json，响应ajax请求
     * @ResponseBody 把处理器方法返回的对象转为json后，通过HttpServletResponse输出给浏览器
     *
     * 处理流程：
     *      1.框架会把返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中的每个类的canWrite()方法
     *        来检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2httpMessageConerter
     *
     *      2.框架会调用实现类的write()方法，--MappingJackson2HttpMessageConverter的write()方法
     *        把Student对象转为json，调用jackson的ObjectMapper实例转为json
     *
     *      3.框架会调用@ResponseBody 把2的结果数据输出到浏览器，ajax请求处理完成
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age) throws IOException {
        // 调用service，获取请求结果数据，Student对象表示结果数据
        // 会被框架转为json
        return new Student(name, age);
    }

    @RequestMapping(value = "/returnStudentJsonList.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectList(String name, Integer age) throws IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student("康师傅", 23));
        students.add(new Student("宋师傅", 22));
        return students;
    }

    /**
     * 处理器方法返回的是String，String表示数据，不是视图
     * 区分返回值是数据还是视图，看看有没有@ResponseBody注解
     * 如果有@ResponseBody注解，返回的就是数据，否则是视图
     *
     * 默认使用"text/plain;charset=ISO-8859-1"作为contextType，导致乱码
     * 给RequestMapping增加属性produces，使用这个属性来指定新的contextType
     *
     * 处理流程：
     * 1.框架会把返回String类型，调用框架中的ArrayList<HttpMessageConverter>中的每个类的canWrite()方法
     * 来检查哪个HttpMessageConverter接口的实现类能处理String类型的数据--StringhttpMessageConerter
     *
     * 2.框架会调用实现类的write()方法，--StringhttpMessageConerter的write()方法
     * 把字符串按照指定的编码来处理 text/plain;charset=ISO-8859-1
     *
     * 3.框架会调用@ResponseBody 把2的结果数据输出到浏览器，ajax请求处理完成
     *
     */
    @RequestMapping(value = "/returnStringData.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age) {
        return "返回对象，表示数据";
    }
}
