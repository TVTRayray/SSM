package org.example.service.Impl;

import org.example.Dao.UserDao;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 依赖注入方式
 * 通过set方法注入
 */
@Service("userService")
public class UserServiceImplDemo implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public void run() {
        userDao.run();
    }
}
