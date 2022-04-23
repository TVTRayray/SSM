package org.example.service.Impl;

import org.example.Dao.UserDao;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserServiceImplDemo1 implements UserService {
    @Override
    public void run() {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.run();

    }
}
