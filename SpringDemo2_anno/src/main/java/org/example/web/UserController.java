package org.example.web;


import org.example.config.SpringConfiguration;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class UserController {
    /**
     * 原始注解的测试
     */
    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.run();

    }

    /**
     * 新注解的测试，可以替代applicationContext文件
     */
    @Test
    public void test2() throws Exception {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.run();
        DataSource datasource = (DataSource) app.getBean("dataSource");
        Connection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}
