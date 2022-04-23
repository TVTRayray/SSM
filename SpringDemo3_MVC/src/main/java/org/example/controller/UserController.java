package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SpringMVC响应数据的方式：
 * （1）页面跳转
 *              返回字符串
 *              通过ModelView对象返回
 * （2）回写数据
 *              直接返回字符串
 *              返回对象或集合
 */
@Controller
//如果在函数上加上RequestMapping，则请求的路径变为http://localhost:8080/user/quick
//后续可以用来区分不同的Controller模块
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick1",method = RequestMethod.GET)//表示只能通过该方法去访问资源
    /**
     * RequestMapping的属性：
     *                      Value：用于指定请求的URL。它和path属性的作用是一样的
     *                      method：用于指定请求的方式
     *                      params：用于指定限制请求参数的条件，支持简单的表达式。要求请求参数的key
     *                              和Value必须配置一模一样
     *                 例如：
     *                      params={"accountName"}，表示请求参数必须有accountName
     *                      params={"money!100"}，表示请求参数中money不能是100
     */
    public String save(){
///------------------------------页面跳转-----------------------------------------------------/
        //SpringMVC页面跳转1：返回字符串
        System.out.println("Controller save running");
        return "redirect:/success.jsp";
        /**
         * 前缀默认是forward:，可以修改为redirect进行重定向
         */
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        //SpringMVC页面跳转2：返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        /**
         * Model:模型 封装数据
         * View: 试图 展示数据
         */

        modelAndView.addObject("username","itcast");
        //设置视图名称
        modelAndView.setViewName("/index.jsp");

        return  modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        //返回ModelAndView的第二种方式
        modelAndView.addObject("username","itcast");
        modelAndView.setViewName("/index.jsp");
        return  modelAndView;
    }
    @RequestMapping("/quick4")
    public String save4(ModelAndView modelAndView){
        //返回ModelAndView和String结合的方式
        modelAndView.addObject("username","itcast");
        modelAndView.setViewName("/index.jsp");
        return  "/index.jsp";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        //这种方式不常用
        request.setAttribute("username","itheima");
        return  "/index.jsp";
    }


///------------------------------回写数据-----------------------------------------------------/
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        //回写数据1：返回字符串
        response.getWriter().print("take care");
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() throws IOException {
        //需要通过ResponseBody来标识这不是进行页面跳转的，进行数据回写
        return "hello Ray";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {
        //手动编写，实现jason格式数据的返回
        User user =new User();
        user.setName("Ray");
        user.setAdd("sc");
        //使用json转换工具，将对象转换为json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public User save9() throws IOException {
        //配置处理器映射器，实现自动转换jason对象，详见spring-mvc.xml
        //可以直接处理对象和集合类型的数据
        User user = new User();
        user.setName("TingTing");
        user.setAdd("GD");
        return user;
    }

}
