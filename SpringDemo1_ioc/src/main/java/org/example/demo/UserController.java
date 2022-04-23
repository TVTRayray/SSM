package org.example.demo;

import org.example.Dao.UserDao;

import org.example.service.UserService;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    /**
     * 1.传统方式Spring统一管理对象
     */

    @Test
    public void Test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService1");
        System.out.println("传统方式Spring统一管理对象");
        userService.run();
    }

    /**
     * 采用依赖注入产生的对象:set方式
     */
    @Test
    public void Test2(){
        System.out.println("采用set方式依赖注入产生的对象");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        采用这种方式去生成对象，因为service对象并不是从Spring容器中获取的，所以找不到对应的UserDao对象,
//                                                                              会报空指针异常
//        UserService userService1 = new UserServiceImplDemo2();
//        userService1.run();
//        Cannot invoke "org.example.Dao.UserDao.run()" because "this.userDao" is null

        //正确方式
        UserService userService2 = (UserService) app.getBean("userService2");
        userService2.run();
    }

    /**
     * 采用依赖注入产生的对象:构造器方式
     */
    @Test
    public void Test3(){
        //采用依赖注入产生的对象
        System.out.println("采用构造器方式依赖注入产生的对象");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService3 = (UserService) app.getBean("userService3");
        userService3.run();
    }

    /**
     *  普通类型、集合类型的注入
     */
    @Test
    public void  Test4(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao2 = (UserDao) app.getBean("userDao2");
        userDao2.run();
    }
}
