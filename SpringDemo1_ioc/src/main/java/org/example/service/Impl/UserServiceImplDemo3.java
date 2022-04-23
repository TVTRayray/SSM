package org.example.service.Impl;

import org.example.Dao.UserDao;
import org.example.service.UserService;

/**
 * 依赖注入方式
 * 通过有参构造器注入方法注入
 */
public class UserServiceImplDemo3 implements UserService {

    //1.
    private UserDao userDao;

    public UserServiceImplDemo3() {
    }

    public UserServiceImplDemo3(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void run() {
        userDao.run();
    }
}
