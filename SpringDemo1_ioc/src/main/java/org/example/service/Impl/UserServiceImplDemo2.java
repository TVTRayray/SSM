package org.example.service.Impl;

import org.example.Dao.UserDao;
import org.example.service.UserService;

/**
 * 依赖注入方式
 * 通过set方法注入
 */
public class UserServiceImplDemo2 implements UserService {

    //1.
    private UserDao userDao;
    //2.
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void run() {
        userDao.run();
    }
}
