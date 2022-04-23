package com.itheima.resolver;

import com.itheima.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 * 实现HandlerExceptionResolver接口，对异常进行判断类型，配置详见spring-mvc
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }
        if(e instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
