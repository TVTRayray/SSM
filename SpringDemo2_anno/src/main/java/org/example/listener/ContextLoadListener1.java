package org.example.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 优化代码，进行解耦操作
 * get applicationContext.xml
 *
 */
@WebListener
public class ContextLoadListener1 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //读取web.xml的全局参数
        ServletContext servletContext = servletContextEvent.getServletContext();

        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        ApplicationContext app =new ClassPathXmlApplicationContext(contextConfigLocation);
        //将Spring的应用上下文对象存储到ServletContext域中

        servletContext.setAttribute("app",app);
        System.out.println("Spring的Listener触发");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
