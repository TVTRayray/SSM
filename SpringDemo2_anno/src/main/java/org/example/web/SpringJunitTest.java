package org.example.web;

import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用Spring集成的Junit进行Test操作，将读取Spring配置文件的过程省略
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        userService.run();
    }

    @Autowired
    private DataSource dataSource;
    @Test
    public  void  test2() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
