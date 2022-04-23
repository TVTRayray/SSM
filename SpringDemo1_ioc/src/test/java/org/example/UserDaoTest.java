package org.example;


import org.example.service.Impl.UserServiceImplDemo1;
import org.example.service.UserService;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public void Test1(){
        UserService userService = new UserServiceImplDemo1();
        userService.run();

    }

}
