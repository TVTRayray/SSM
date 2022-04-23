package org.example.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 通过listener来读取配置文件并获得一个公用的Bean对象，有利于资源的节省，将Bean对象存储到域中
 */
@WebListener
public class ContextLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //将Spring的应用上下文对象存储到ServletContext域中
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("app",app);
//        System.out.println("Spring的Listener触发");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
