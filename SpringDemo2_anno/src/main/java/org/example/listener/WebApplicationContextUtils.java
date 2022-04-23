package org.example.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * 模拟源码里面的WebApplicationContextUtils的使用
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
