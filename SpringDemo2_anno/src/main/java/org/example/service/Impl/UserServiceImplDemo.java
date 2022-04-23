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

    //1.
//    @Autowired
    //@Qualifier("userDao")

    //2.@Resource=@Autowired+@Qualifier("userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    /**
     * 通过注解的方式，可以直接省略set方法不写
     * Qualifier也可以省略，前提是spring中已经存在当所需要对象的类型
     */
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void run() {
        userDao.run();
    }
}
