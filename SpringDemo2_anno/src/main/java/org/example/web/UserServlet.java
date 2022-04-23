package org.example.web;

import org.example.listener.WebApplicationContextUtils;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这种方法其实存在弊端：每次编写servlet代码时都会创建一个BEAN对象，会浪费资源
 * 可以尝试设置监听器的方法来解决这个问题，具体方法看listener
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //配置了监听器后，就可以不使用下面的方法获取Bean对象了
        // ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext servletContext = this.getServletContext();
        //使用工具类WebApplicationContextUtils来获取app对象
        //ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        ApplicationContext app = WebApplicationContextUtils.getApplicationContext(servletContext);
        UserService userService = (UserService) app.getBean("userService");
        userService.run();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
